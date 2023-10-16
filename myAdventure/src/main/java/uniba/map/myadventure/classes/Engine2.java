/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import uniba.map.myadventure.interfaces.Grafica;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuse
 */
public class Engine2 {

    private final GameDescription game;

    private Parser parser;

    public Engine2(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File("./resources/stopwords"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void inizialized(Grafica grafica) {
        grafica.appendToScreen("================================ ");
        grafica.appendToScreen("* Adventure Castle Game v. 0.3 - 2022-2023 * ");
        grafica.appendToScreen("================================ ");
        grafica.appendToScreen(game.getCurrentRoom().getName());
        grafica.appendToScreen("");
        grafica.appendToScreen(game.getCurrentRoom().getDescription());
        grafica.appendToScreen("");
    }

    public void execute(Grafica grafica) {

        String input = grafica.getValueWriter();

        String command = input.toLowerCase();
        ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());
        if (p == null || p.getCommand() == null) {
            grafica.appendToScreen("Non capisco quello che mi vuoi dire. ");
        } else if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
            grafica.appendToScreen("Addio! ");
            try {
                Thread.sleep(5000);
                //TODO:  gestire il comando addio
            } catch (InterruptedException ex) {
                Logger.getLogger(Engine2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);

        } else {
            game.nextMove(p, grafica);
            grafica.appendToScreen("");
        }
    }
    
    //TODO: in caso eliminarlo del tutto
    /**
     * @param args the command line arguments
     */
    /*  public static void main(String[] args) {
        Engine2 engine = new Engine2(new AdventureCastleGame());
        engine.execute();
        
    }*/
    
    /*TODO: creazione database e salvataggio di partita corrente solo per salvaggio in caso di morte
            completare il main: la schermata di interfaccia che permette di interagire senza dover passare dalla console
            thread sullo scorrere del tempo
            lambda expression da utilizzare da qualche parte
            completare il next move:
                ripostiglio            
                biblioteca
                cortile: aggiungere oltre ad apri cilindro il movimento arrampicata
                soggiorno
                cucina
                sala da pranzo: azione colpisci e le eventuali risposte del nemico
                stanza servitù (crollata): aggiungere descrizione a diario
                armeria: differenza con sala da pranzo tizio che dorme/aggiungere comando unisci oggetti se più di uno altrimenti oggetto rampino è già intero
                bagno
                anticamere: se avanza tempo fare il comando unisci altrimenti le lenzuola si trovano già annodate.
                camera da letto figlia
                camera da letto figlio
                bagno
                vuoto: la morte
                camera padronale
                balcone camera padronale
                balcone anticamera
                studio
                torre
            fare il comando "usa" per rampino, lenzuola ecc
            Modificare mappe in maniera da aggiungere il precipizio
            qualcosa per le restful o socket
            Documentazione:
                breve descrizione generale del caso di studio
                un diagramma delle classi con una descrizione; il diagramma delle classi deve riportare una parte significativa del codice sviluppato
                una specifica algebrica di una struttura dati utilizzata nel caso di studio
                una descrizione di come avete applicato i vari argomenti del corso (file, JDBC, socket, lambda expression, thread, ...) al caso di studio
                opzionalmente potete anche consegnare la javadoc del vostro progetto che non sostituisce la documentazione che va comunque consegnata
                la documentazione può anche essere scritta in Markdown nel repository github se optate per questa modalità di consegna
            gestione descrizioni tramite file
            finale storia
            comando "help"
            bottone mappa
            suddivisione progetto in più package*/
}
/*TODO: Stanze fatte:   Dispensa
                        Ingresso
                        scale*/