/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.interfaces;

/**
 *
 * @author cristina
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IndovinelloUI extends JFrame {
    
    private boolean compelteRiddles = false; 

    public boolean isCompelteRiddles() {
        return compelteRiddles;
    }

    public void setCompelteRiddles(boolean compelteRiddles) {
        this.compelteRiddles = compelteRiddles;
    }

    public IndovinelloUI() {
        Map <String,String> indovinelliMap= new HashMap <> ();
        indovinelliMap.put("Oliver Twist", "Sono diventato un classico della letteratura inglese, e racconto le avventure di un giovane orfano che vive a Londra insieme a personaggi stravaganti come Mr. Sowerberry e Fagin. Chi sono io?");
        indovinelliMap.put("Il Signore degli Anelli", "Sono una trilogia di romanzi fantasy ambientata in un mondo magico popolato da creature come elfi, nani e orchi. Il mio autore ha creato un linguaggio completamente nuovo per il mio mondo. Chi sono io?");
        indovinelliMap.put("Alice nel Paese delle Meraviglie", "Sono un romanzo che ha come protagonista una giovane ragazza che si ritrova in un mondo fantastico pieno di creature insolite come il Coniglio Bianco e il Cappellaio Matto. Chi sono io?");
        
        // Imposta il titolo e la dimensione del frame
        setTitle("Indovinello");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(380, 400); // Width, Height

        // Crea il GridBagLayout e il GridBagConstraints
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Componenti comuni GridBagConstraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Crea il label dell'indovinello
        JLabel labelRiddle = new JLabel("Indovinello");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(labelRiddle, gbc);

        // Crea un'area di testo per il testo dell'indovinello
        JTextArea textRiddleArea = new JTextArea(5, 20); // 5 righe di altezza, 20 colonne di larghezza
        textRiddleArea.setText(indovinelliMap.get("Oliver Twist"));
        textRiddleArea.setWrapStyleWord(true);
        textRiddleArea.setLineWrap(true);
        textRiddleArea.setEditable(false);
        textRiddleArea.setBackground(getBackground()); // Imposta lo sfondo come il background del frame

        // Aggiungi un JScrollPane per l'area di testo dell'indovinello
        JScrollPane scrollPane = new JScrollPane(textRiddleArea);
        gbc.gridy = 1;
        gbc.ipady = 40; // Fornisce spazio extra in verticale
        add(scrollPane, gbc);

        // Crea una combo box per la scelta dei libri
        String[] books = { "Harry Potter", "Oliver Twist", "Il Piccolo Principe","Il Codice da Vinci","Alice nel Paese delle Meraviglie","Cime tempestose","Orgoglio e Pregiudizio", "Il Nome della Rosa","Il Signore degli Anelli","Don Chisciotte"};
        JComboBox<String> bookList = new JComboBox<>(books);
        gbc.gridy = 2;
        gbc.ipady = 0; // Reset dell'altezza extra
        add(bookList, gbc);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Personalizza qui la logica da eseguire quando la finestra viene chiusa
                int choice = JOptionPane.showConfirmDialog(IndovinelloUI.this, "Vuoi davvero uscire?", "Conferma uscita", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    IndovinelloUI.this.dispose();
                }
            }
        });
        
        // Add event when en item is selected
        bookList.addActionListener(e -> {
            String selectedBook = (String) bookList.getSelectedItem();
            // Cambiare il messaggio con la logica del gioco
            if (Objects.equals(indovinelliMap.get(selectedBook), textRiddleArea.getText())) {
                JOptionPane.showMessageDialog(this, "Esatto");
                if(selectedBook.equals("Oliver Twist"))
                    textRiddleArea.setText(indovinelliMap.get("Il Signore degli Anelli"));
                if(selectedBook.equals("Il Signore degli Anelli"))
                    textRiddleArea.setText(indovinelliMap.get("Alice nel Paese delle Meraviglie"));
                if(selectedBook.equals("Alice nel Paese delle Meraviglie")){
                    System.out.println("Prossimo livello");
                    setCompelteRiddles(true);
                    dispose();
                }
                    
            } else {
                JOptionPane.showMessageDialog(this, "Sbagliato");
            }
        });

        // Crea i bottoni
        JButton buttonExit = new JButton("Exit");

        // Aggiunge funzionalità al bottone Exit
        buttonExit.addActionListener(e -> dispose());

        // Pannello per i bottoni
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(buttonExit);

        // Aggiunta del pannello dei bottoni
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; // Dà spazio extra nella parte inferiore
        add(buttonPanel, gbc);
        setVisible(true);
    }
}
