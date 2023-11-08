package uniba.map.myadventure.interfaces;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import uniba.map.myadventure.classes.AdventureCastleGame;
import uniba.map.myadventure.classes.Engine2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author giuse
 */
public class Grafica extends javax.swing.JFrame {

    /**
     * Creates new form Grafica
     */
    public final Engine2 engine = new Engine2(new AdventureCastleGame(),this);
    private JFrame mappaFrame1 = null;
    private JFrame mappaFrame2 = null;

    public Grafica() {
        initComponents();
        engine.start2();
    }
    
    public void appendToScreen(String text) {
        screen.append(text + "\n");
    }

    public String getValueWriter() {
        String input = null;
        return input = writer.getText();
    }

    public boolean isEnterPressed() {
        return writer.getText().endsWith("\n");
    }
    //TODO: modificare lo scroll in maniera che faccia sempre vedere l'ultima riga
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelText = new javax.swing.JPanel();
        writer = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        help = new javax.swing.JButton();
        suggerimento = new javax.swing.JButton();
        mappa1 = new javax.swing.JButton();
        mappa2 = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        screen = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adventur Castle Game");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(getPreferredSize());

        writer.setAlignmentX(1.0F);
        writer.setAlignmentY(2.0F);
        writer.setMargin(new java.awt.Insets(2, 8, 2, 6));
        writer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTextLayout = new javax.swing.GroupLayout(panelText);
        panelText.setLayout(panelTextLayout);
        panelTextLayout.setHorizontalGroup(
            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writer, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
        panelTextLayout.setVerticalGroup(
            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(writer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelText, java.awt.BorderLayout.PAGE_END);

        help.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        help.setText("Help");
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });

        suggerimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suggerimento.setText("Suggerimento");

        mappa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mappa1.setText(" Mappa 1");
        mappa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mappa1MouseClicked(evt);
            }
        });

        mappa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mappa2.setText("Mappa 2");
        mappa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mappa2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suggerimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mappa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mappa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addComponent(mappa1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mappa2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(suggerimento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        getContentPane().add(panelButton, java.awt.BorderLayout.LINE_END);

        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPane.setRowHeaderView(null);

        screen.setEditable(false);
        screen.setColumns(20);
        screen.setLineWrap(true);
        screen.setRows(5);
        screen.setWrapStyleWord(true);
        screen.setAlignmentX(1.0F);
        screen.setAlignmentY(2.0F);
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        screen.setMargin(new java.awt.Insets(2, 8, 2, 6));
        scrollPane.setViewportView(screen);

        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void writerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writerActionPerformed
        String input = writer.getText(); // Acquisisci il testo inserito dall'utente
        screen.append("> " + input + "\n"); // Aggiungi il testo alla JTextArea screen
        engine.execute();
        writer.setText(""); // Resetta il campo di testo jTextField
    }//GEN-LAST:event_writerActionPerformed
    
    private void mappa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mappa1MouseClicked
        // Recupera il percorso dell'immagine della mappa come stringa
        String mappaImagePath = "C:\\Users\\giuse\\OneDrive\\Desktop\\prove di codici\\Progetto-MAP\\Mappe\\1 piano da visualizzare.png";

        if (mappaFrame1 != null && mappaFrame1.isVisible()) {
            // Se la finestra della mappa è già aperta, chiudila e annulla il riferimento
            mappaFrame1.dispose();
            mappaFrame1 = null;
        } else {
            // Se la finestra della mappa non è aperta, crea una nuova finestra e mostra l'immagine
            if (mappaFrame1 == null) {
                // Crea una nuova finestra solo se la finestra non esiste ancora
                mappaFrame1 = new JFrame("Mappa Primo piano");
                mappaFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Recupera l'immagine originale dalla posizione del file
                ImageIcon imageIcon = new ImageIcon(mappaImagePath);
                Image image = imageIcon.getImage();

                // Ridimensiona l'immagine mantenendo l'integrità
                int newWidth = 500; // Nuova larghezza in pixel
                int newHeight = -1; // Altezza proporzionale alla larghezza
                Image newImage = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);

                // Crea un nuovo ImageIcon a partire dall'immagine ridimensionata
                ImageIcon newImageIcon = new ImageIcon(newImage);

                // Crea un JLabel con il nuovo ImageIcon e aggiungilo al JFrame
                JLabel mappaLabel = new JLabel(newImageIcon);
                mappaFrame1.getContentPane().add(mappaLabel);

                // Imposta le dimensioni del JFrame e visualizzalo
                mappaFrame1.pack();
                // Imposta la posizione della finestra 
                int x = Toolkit.getDefaultToolkit().getScreenSize().width - mappaFrame1.getWidth() - 120; // 10 pixel di margine a sinistra
                int y = 120; // 10 pixel di margine superiore
                mappaFrame1.setLocation(x, y);
                // Imposta la finestra in primo piano
                mappaFrame1.setAlwaysOnTop(true);
            }

            // Visualizza la finestra della mappa
            mappaFrame1.setVisible(true);
        }
    }//GEN-LAST:event_mappa1MouseClicked

    private void mappa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mappa2MouseClicked
        // Recupera il percorso dell'immagine della mappa come stringa
        String mappaImagePath = "C:\\Users\\giuse\\OneDrive\\Desktop\\prove di codici\\Progetto-MAP\\Mappe\\2 piano da visualizzare.png";

        if (mappaFrame2 != null && mappaFrame2.isVisible()) {
            // Se la finestra della mappa è già aperta, chiudila e annulla il riferimento
            mappaFrame2.dispose();
            mappaFrame2 = null;
        } else {
            // Se la finestra della mappa non è aperta, crea una nuova finestra e mostra l'immagine
            if (mappaFrame2 == null) {
                // Crea una nuova finestra solo se la finestra non esiste ancora
                mappaFrame2 = new JFrame("Mappa Secondo piano");
                mappaFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Recupera l'immagine originale dalla posizione del file
                ImageIcon imageIcon = new ImageIcon(mappaImagePath);
                Image image = imageIcon.getImage();

                // Ridimensiona l'immagine mantenendo l'integrità
                int newWidth = 500; // Nuova larghezza in pixel
                int newHeight = -1; // Altezza proporzionale alla larghezza
                Image newImage = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);

                // Crea un nuovo ImageIcon a partire dall'immagine ridimensionata
                ImageIcon newImageIcon = new ImageIcon(newImage);

                // Crea un JLabel con il nuovo ImageIcon e aggiungilo al JFrame
                JLabel mappaLabel = new JLabel(newImageIcon);
                mappaFrame2.getContentPane().add(mappaLabel);

                // Imposta le dimensioni del JFrame e visualizzalo
                mappaFrame2.pack();
                // Imposta la posizione della finestra  
                int x = Toolkit.getDefaultToolkit().getScreenSize().width - mappaFrame2.getWidth() - 120; // 10 pixel di margine a sinistra
                int y = 120; // 10 pixel di margine superiore
                mappaFrame2.setLocation(x, y);
                // Imposta la finestra in primo piano
                mappaFrame2.setAlwaysOnTop(true);
            }

            // Visualizza la finestra della mappa
            mappaFrame2.setVisible(true);
        }
    }//GEN-LAST:event_mappa2MouseClicked

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        JOptionPane.showMessageDialog(this, " Comandi disponibili: \n FINE, INVENTARIO, NORD, SUD, EST, OVEST" +
"    OSSERVA, RIEMPI, COLPISCI, LANCIA, SALI,\n" +
"    APRI,SCENDI, BEVI, SVUOTA, GIOCA", "Comandi utilizzabili", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Grafica().setVisible(false);
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton help;
    private javax.swing.JButton mappa1;
    private javax.swing.JButton mappa2;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelText;
    private javax.swing.JTextArea screen;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton suggerimento;
    private javax.swing.JTextField writer;
    // End of variables declaration//GEN-END:variables
}
