/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseManagement {
    
    // metodo per aprire la connessione al database
    public static Connection connectToDatabase() throws SQLException {
        String user = "root";
        String pass = "root";
        String dbName = "AdvCastel";
        String host = "localhost";
        int port = 3306; // porta di default di mysql

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        // Apre una connessione al database e la restituisce
        return DriverManager.getConnection(url, user, pass);
    }
    
    // Metodo per chiudere la connessione al database
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connessione al database chiusa con successo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     // Metodo per verificare se un nome utente esiste nel database
    public static boolean isUsernameExists(String nomeUtente) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    boolean usernameExists = false;

    try {
        conn = connectToDatabase();
        String sql = "SELECT * FROM Giocatore WHERE nomeUtente = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nomeUtente);  
        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            String utente = resultSet.getString("nomeUtente");
            System.out.println(utente);
            // Esegui altre operazioni se necessario con i dati del risultato
            // ...
            usernameExists = true; // Imposta a true se almeno un risultato viene restituito
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gestisci l'eccezione se necessario
    } finally {
        closeResources(conn, pstmt, resultSet);
    }

    return usernameExists;
}




    // Metodo per chiudere la connessione e altre risorse
    private static void closeResources(Connection conn, PreparedStatement pstmt, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            // Gestisci eventuali eccezioni durante la chiusura delle risorse
            
        }
    }

}
