/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package uniba.map.myadventure.classes.SeAvanzaTempo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import uniba.map.myadventure.classes.ObjectAdv;

/**
 *
 * @author Sensei Tequila
 */
public class h2 {
    
    
    /**
     *
     */
    public static final String CREATE_PLAYER = "CREATE TABLE IF NOT EXISTS Giocatore (id INT AUTO_INCREMENT PRIMARY KEY, "
            + "nomeUtente VARCHAR(255), "
            + "posizioneGioco varchar(255))";
    
    public static final String CREATE_OBJECTS = "CREATE TABLE IF NOT EXISTS Oggetti (id INT PRIMARY KEY, "
            + "nome VARCHAR(255), " 
            + "descrizione TEXT, "
            + "alias TEXT, "
            + "openable BOOLEAN, "
            + "pickupable BOOLEAN,"
            + "pushable BOOLEAN, "
            + "aperto BOOLEAN, "
            + "push BOOLEAN, "
            + "fillable BOOLEAN, "
            + "filled BOOLEAN, "
            + "fragile BOOLEAN, "
            + "visible BOOLEAN)";
    
    public static final String INSERT_OGGETTI = "INSERT INTO Oggetti (id, nome, descrizione, alias, openable, pickupable, pushable, aperto, push, fillable, filled, fragile, visible) "
            + "VALUES "
            + "(7, 'Corda', 'Una corda molto resistente', 'laccio,fune', false, true, false, false, false, false, false, false, true),"
            + "(8, 'Scotch', 'Un semplice nastro adesivo', 'nastro', false, true, false, false, false, false, false, true, true),"
            + "(9, 'Benzina', 'Una tanica di benzina piena', 'carburante,tanica,combustibile', false, true, false, false, false, false, false, false, true),"
            + "(10, 'Martello', 'Un martello molto pratico per ottime martellate', 'mazzola', false, true, false, false, false, false, false, false, true),"
            + "(11, 'Chiodi', 'Dei chiodi molto utili se si ha un martello', 'puntine,viti', false, true, false, false, false, false, false, false, true);";
    
    public static final String INSERT_OGGETTI2 = "INSERT INTO Oggetti (id, nome, descrizione, alias, openable, pickupable, pushable, aperto, push, fillable, filled, fragile, visible)"
            + "VALUES "
            + "(12, 'Secchio', 'Un secchio pieno d''acqua', 'bidone', true, true, false, false, false, true, false, false, true),"
            + "(13, 'Palanghino', 'Un palanghino utile per qualsiasi idea di scasso vi passi per la testa', 'leva', false, true, false, false, false, false, false, false, true),"
            + "(15, 'Piatto', 'Un piatto con ancora del cibo al loro interno, chissà se è buono', 'stoviglia,porcellana', false, true, false, false, false, false, false, true, true),"
            + "(16, 'Posata', 'Utili per afferrare cosa c''è nel piatto', 'argenteria', false, true, false, false, false, false, false, false, true), "
            + "(17, 'Bicchiere', 'Utili per bere qualsiasi fluido', 'calice,tazza', false, true, false, false, false, false, false, true, true), "
            + "(19, 'Candela', 'Ottime per illuminare e scaldare un ambiente', 'lumino', false, true, false, false, false, false, false, true, true), "
            + "(21, 'Chiave', 'Una chiave che probabilmente può aprire una serratura', 'chiave', false, true, false, false, false, false, false, false, true), "
            + "(22, 'Bigliettino', 'Descrizione del foglietto', 'foglio,lettera', false, true, false, false, false, false, false, false, true);";
            
    
    public static final String INSERT_OGGETTI3 = "INSERT INTO Oggetti (id, nome, descrizione, alias, openable, pickupable, pushable, aperto, push, fillable, filled, fragile, visible)"
            + "VALUES "
            + "(90, 'Chiave', 'Una chiave utile per aprire una serratura, chissà quale', 'chiave', false, true, false, false, false, false, false, false, true), "
            + "(29, 'Lettera', 'Uno dei fogli sembra una lettera. Parla di un certo Franchino che va in giro per il paese a rubare. Spesso entra nelle case e indisturbato si aggira recuperando tutto quello che gli sembra prezioso. Una frase ti stuzzica più delle altre: \"Per sentirti più al sicuro, il nonno ha costruito una nicchia all''interno del camino in cui nascondere le cose più preziose\". Il resto della lettera racconta di feste e banchetti.', 'busta,lettera', false, false, false, false, false, false, false, false, true), "
            + "(30, 'Chiave', 'Una chiave utile per aprire una serratura, chissà quale', '3', false, true, false, false, false, false, false, false, true), "
            + "(35, 'Bottiglia di Vino', 'Una normale bottiglia al cui interno sembra esserci una chiave', 'vino', true, false, false, false, false, false, true, true, true), "
            + "(36, 'Chiave', 'Una chiave utile per aprire una serratura, chissà quale', 'chiave', false, true, false, false, false, false, false, false, true), "
            + "(39, 'accetta', 'Un arma molto pratica per mozzare teste', 'ascia', false, true, false, false, false, false, false, false, true), "
            + "(40, 'falcione', 'L''arma prediletta dalla signora morte, molto amata anche dagli agricoltori', 'falce', false, true, false, false, false, false, false, false, true), "
            + "(41, 'lancia', 'un arma usata nell''era glaciale per abbattere i mammut, ottima per il suo periodo storico', 'giavellotto', false, true, false, false, false, false, false, false, true), "
            + "(42, 'spada', 'ottima nelle grandi battaglie, questa sembra sia salda al muro', 'lama', false, true, false, false, false, false, false, false, true), "
            + "(43, 'chiave', 'una chiave utile per aprire una serratura, chissà quale', 'chiave', false, true, false, false, false, false, false, false, true), "
            + "(44, 'Guardiano', 'Lui è Robert il guardiano di questo castello, a lui non sfugge nulla, neanche quando dorme', 'custode', false, false, false, false, false, false, false, false, true),"
            + "(45, 'rampino', 'un oggetto che se lanciato si aggrappa ovunque, ma inutile senza una corda', 'rampino', false, true, false, false, false, false, false, false, true);";
            
    public static final String INSERT_OGGETTI5 = "INSERT INTO Oggetti (id, nome, descrizione, alias, openable, pickupable, pushable, aperto, push, fillable, filled, fragile, visible)"
            + "VALUES "        
            + "(50, 'lettera', 'Caro James, se stai leggendo questa lettera vuole dire che sono fuggito, mi avevano quasi preso quei maledetti cosacchi. Menomale che mio nonno fece costruire un passaggio segreto: lo usava per fuggire dal castello dove sgattaiolava per raggiungere le sue giovani amiche del bordello. "
            + "Inoltre questo passaggio portava in cima ad una torre dove nascondeva la sua collezione di vini. Il passaggio è raffigurato in un quadro, trova l''ingresso e portami una di quelle bottiglie."
            + "Ti aspetto fuori dalle mura del castello: mi raccomando James non dimenticarti le bottiglie!', 'biglietto', false, true, false, false, false, false, false, false, true);"; 

    public static final String CREATE_INVENTORY = "CREATE TABLE IF NOT EXISTS Inventario (id INT PRIMARY KEY auto_increment, "
            + "idGiocatore INT, "
            + "idOggetto INT, "
            + "FOREIGN KEY (idGiocatore) REFERENCES Giocatore(id), "
            + "FOREIGN KEY (idOggetto) REFERENCES Oggetti(id))";            

    private static String username;
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        
        try {
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "1234");
            conn = DriverManager.getConnection("jdbc:h2:./resources/db/AdventureCastleGame", dbprops);
            System.out.println("Connessione al database aperta con successo.");
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_PLAYER);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(CREATE_OBJECTS);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(INSERT_OGGETTI);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(INSERT_OGGETTI2);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(INSERT_OGGETTI3);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(INSERT_OGGETTI5);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate(CREATE_INVENTORY);
            stm.close();
            
            String selectQuery = "SELECT * FROM Oggetti;";
            
            PreparedStatement pstm = conn.prepareStatement(selectQuery);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getString("id"));
                System.out.println("\t nome: " + resultSet.getString("nome"));
                System.out.println("\t descrizione: " + resultSet.getString("descrizione"));
                System.out.println("\t alias: " + resultSet.getString("alias"));
                System.out.println("\t openable: " + resultSet.getString("openable"));
                System.out.println("\t pickupable: " + resultSet.getString("pickupable"));
                System.out.println("\t pushable: " + resultSet.getString("pushable"));
                System.out.println("\t aperto: " + resultSet.getString("aperto"));
                System.out.println("\t push: " + resultSet.getString("push")); 
                System.out.println("\t fillable: " + resultSet.getString("fillable"));
                System.out.println("\t filled: " + resultSet.getString("filled"));
                System.out.println("\t fragile: " + resultSet.getString("fragile"));
                System.out.println("\t visible: " + resultSet.getString("visible"));
            }
            
            conn.close();
            System.out.println("Connessione al database chiusa con successo.");
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }        
    }
    
    public static String getUsername() {
        return username;
    }
    
    public static void setUsername(String username) {
        h2.username = username;
    }
    
    // metodo per aprire la connessione al database
    public Connection connectToDatabase() throws SQLException {
        Properties dbprops = new Properties();
        dbprops.setProperty("user", "user");
        dbprops.setProperty("password", "1234");
        Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db/AdventureCastleGame", dbprops);
        
        System.out.println("Connessione al database aperta con successo.");
        
        // Apre una connessione al database e la restituisce
        return conn;
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
            System.err.println(e.getSQLState() + ": " + e.getMessage());
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
            System.err.println(e.getSQLState() + ": " + e.getMessage());
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
                boolean visible = resultSet.getBoolean("visible");
                
                // Separare le stringhe usando un delimitatore (ad esempio una virgola)
                String[] aliasArray = aliasString.split(",");
                
                // Creare un insieme da array di stringhe
                Set<String> aliasSet = new HashSet<>(Arrays.asList(aliasArray));
                
                ObjectAdv oggetto = new ObjectAdv(id, nome, descrizione, aliasSet, openable, pickupable, pushable, aperto, push, fillable, filled, fragile, visible);
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
            // Ottenere l'ID del giocatore dal nome utente
            conn = connectToDatabase();
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
