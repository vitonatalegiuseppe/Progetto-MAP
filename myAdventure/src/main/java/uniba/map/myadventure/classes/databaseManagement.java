/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;
//import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class databaseManagement {
    
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        databaseManagement.username = username;
    }
    
    
    
    // metodo per aprire la connessione al database
    public  Connection connectToDatabase() throws SQLException {
        String user = "root";
        String pass = "root";
        String dbName = "AdvCastel";
        String host = "localhost";
        int port = 3306; // porta di default di mysql

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
         System.out.println("Connessione al database aperta con successo.");

        // Apre una connessione al database e la restituisce
        return DriverManager.getConnection(url, user, pass);
    }
    
 

     // Metodo per verificare se un nome utente esiste nel database
    public boolean isUsernameExists() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        boolean usernameExists = false;

        try {
            conn = connectToDatabase();
            String sql = "SELECT * FROM Giocatore WHERE nomeUtente = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                // Se il nome utente è presente nel database
                usernameExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione se necessario
        } finally {
            closeResources(conn, pstmt, resultSet);
           
        }

        return usernameExists;
}

public boolean insertNewUser() throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = connectToDatabase();
        String sql = "INSERT INTO Giocatore (nomeUtente) VALUES (?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        int rowsAffected = pstmt.executeUpdate();

        // Restituisci true se l'inserimento ha avuto successo
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        // Gestisci l'eccezione se necessario
    } finally {
        closeResources(conn, pstmt, null);
    }

    // Restituisci false se l'inserimento non ha avuto successo
    return false;
}



    // Metodo per chiudere la connessione e altre risorse
    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                 
            }
            if (pstmt != null) {
                pstmt.close();
               
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                 System.out.println("Connessione al database chiusa con successo.");
            }
        } catch (SQLException e) {
            // Gestisci eventuali eccezioni durante la chiusura delle risorse
            
        }
    }
    
    
    public List<ObjectAdv> getOggettiUtente() {
        List<ObjectAdv> oggetti = new ArrayList<>();
        Connection conn = null;
        PreparedStatement selectStatement = null;
        ResultSet resultSet = null;

        try {
            conn = connectToDatabase();
            String selectQuery = "SELECT * FROM Oggetti o " +
                                 "JOIN Inventario i ON o.id = i.idOggetto " +
                                 "JOIN Giocatore g ON g.id = i.idGiocatore " +
                                 "WHERE g.nomeUtente = ?";

            selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, username);
            resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String descrizione = resultSet.getString("descrizione");
                String aliasString = resultSet.getString("alias");
                boolean openable = resultSet.getBoolean("openable");
                boolean pickupable = resultSet.getBoolean("pickupable");
                boolean pushable = resultSet.getBoolean("pushable");
                boolean aperto = resultSet.getBoolean("aperto");
                boolean push = resultSet.getBoolean("push");
                boolean fillable = resultSet.getBoolean("fillable");
                boolean filled = resultSet.getBoolean("filled");
                boolean fragile = resultSet.getBoolean("fragile");

                // Separare le stringhe usando un delimitatore (ad esempio una virgola)
                String[] aliasArray = aliasString.split(",");

                // Creare un insieme da array di stringhe
                Set<String> aliasSet = new HashSet<>(Arrays.asList(aliasArray));

                ObjectAdv oggetto = new ObjectAdv(id, nome, descrizione, aliasSet, openable, pickupable, pushable, aperto, push, fillable, filled, fragile);
                oggetti.add(oggetto);
                
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeResources(conn, selectStatement, resultSet);
        }

        return oggetti;
}
    
 public void saveObjectsToDatabase(List<ObjectAdv> objects) {
    Connection conn = null;
    PreparedStatement deleteStatement = null;
    PreparedStatement insertInventarioStatement = null;

    try {
        conn = connectToDatabase();

        // Ottenere l'ID del giocatore dal nome utente
        int playerId = getPlayerIdByUsername();


        // Elimina gli oggetti legati al giocatore dall'inventario
        String deleteQuery = "DELETE FROM Inventario WHERE idGiocatore = ?";
        try  {
            deleteStatement = conn.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, playerId);
            deleteStatement.executeUpdate();
             
        }finally{
            closeResources(null, deleteStatement, null);
        }
     
        // Inserisci i nuovi oggetti nell'inventario
        String insertInventarioQuery = "INSERT INTO Inventario (idGiocatore, idOggetto) VALUES (?, ?)";
        try  {
            insertInventarioStatement = conn.prepareStatement(insertInventarioQuery);
        
            for (ObjectAdv object : objects) {
                // Inserisci oggetto nell'inventario
                insertInventarioStatement.setInt(1, playerId);
                insertInventarioStatement.setInt(2, object.getId());
                insertInventarioStatement.executeUpdate();
            }
             
        
        }finally{
            closeResources(null, insertInventarioStatement, null);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gestisci l'eccezione secondo le tue necessità
    } finally {
        // Chiudi la connessione dopo l'utilizzo
       closeResources(conn, null, null);
    }
}




// Metodo per ottenere l'ID del giocatore dal nome utente
private int getPlayerIdByUsername() {
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int playerId = -1; // Valore di default nel caso in cui non sia stato trovato alcun giocatore

    try {
        conn = connectToDatabase();
        // Esegui una query per ottenere l'ID del giocatore dal nome utente
        String query = "SELECT id FROM Giocatore WHERE nomeUtente = ?";
       
            statement = conn.prepareStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Se il risultato contiene una riga, ottieni l'ID del giocatore
                    playerId = resultSet.getInt("id");
                }
            
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
         closeResources(conn, statement, resultSet);
    }

    return playerId;
}


}