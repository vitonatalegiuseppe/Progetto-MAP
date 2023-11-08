/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uniba.map.myadventure.interfaces;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uniba.map.myadventure.classes.AdventureCastleGame;
import uniba.map.myadventure.classes.Engine2;
import uniba.map.myadventure.classes.GameDescription;
import uniba.map.myadventure.classes.databaseManagement;
import static uniba.map.myadventure.classes.databaseManagement.setUsername;

/**
 *
 * @author giuse
 */
public class StartGame extends javax.swing.JFrame {

    /**
     * Creates new form StartGame
     */
   
    
    private Engine2 engine;

   
    public StartGame(Engine2 engine) {
        initComponents();
        this.engine = engine;
        setLocationRelativeTo(null);
    }
    //todo:gestire la chiusura con la x visto che il gioco parte da engine quindi se si clicca la x il gioco termina

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelText = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adventur Castel Game");

        username.setText("Username");
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });

        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setText("Inserisci il tuo username per iniziare a giocare");

        javax.swing.GroupLayout PanelTextLayout = new javax.swing.GroupLayout(PanelText);
        PanelText.setLayout(PanelTextLayout);
        PanelTextLayout.setHorizontalGroup(
            PanelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTextLayout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(PanelTextLayout.createSequentialGroup()
                .addGroup(PanelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTextLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTextLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(login)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTextLayout.setVerticalGroup(
            PanelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTextLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(login)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        getContentPane().add(PanelText, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

          
        databaseManagement databaseManagement = new databaseManagement();
       
        if(username.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "il campo è vuoto", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            setUsername(username.getText());
            try {
                if(databaseManagement.isUsernameExists()){

                    int option = JOptionPane.showConfirmDialog(this, "Il nome utente è esistente, vuoi caricare i dati di gioco?", "Ripristino dati", JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        engine.setUtenteExiste(true);
                        JOptionPane.showMessageDialog(this, "Dati caricati con successo, buon divertimento !", "Successo", JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        //sovrascrivi i nuovi dati
                         engine.setUtenteExiste(false);
                       JOptionPane.showMessageDialog(this, "Stai per iniziare una nuova partita", "", JOptionPane.INFORMATION_MESSAGE);

                    }

                }else{
                    if(databaseManagement.insertNewUser()){
                     engine.setUtenteExiste(false);
                     JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo", "", JOptionPane.INFORMATION_MESSAGE);

                    } 
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
           //TODO: gestire l'eccezione in maniera piu chiara
            }
            
            dispose();
        }
     
    }//GEN-LAST:event_loginActionPerformed

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        username.setText("");
    }//GEN-LAST:event_usernameMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
