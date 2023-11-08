/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import uniba.map.myadventure.interfaces.Grafica;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author giuse
 */
public class Engine2 {

    private final GameDescription game;

    private Parser parser;
    
    static Grafica grafica = new Grafica();

    static public void appendToScreenEngine(String text) {
        grafica.appendToScreen(text);
    }

    public Engine2(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File("./resources/File/stopwords"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void inizialized() {
        grafica.appendToScreen("================================ ");
        grafica.appendToScreen("* Adventure Castle Game v. 0.3 - 2022-2023 * ");
        grafica.appendToScreen("================================ ");
        grafica.appendToScreen(game.getCurrentRoom().getName());
        grafica.appendToScreen("");
        grafica.appendToScreen(game.getCurrentRoom().getDescription());
        grafica.appendToScreen("");
    }

    public void execute() {

        String input = grafica.getValueWriter();

        String command = input.toLowerCase();
        ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());
        if (p == null || p.getCommand() == null) {
            grafica.appendToScreen("Non capisco quello che mi vuoi dire. ");
        } else {
            game.nextMove(p);
            grafica.appendToScreen("");
        }
    }
    
    public static void main(String[] args) {
        Engine2 engine = new Engine2(new AdventureCastleGame());
        grafica.setVisible(true);
        engine.inizialized();
    }
    
    /*TODO: creazione database e salvataggio di partita corrente solo per salvaggio in caso di morte
            migliorare il main
            lambda expression da utilizzare da qualche parte
            completare il next move:
                biblioteca: una volta entrati, si devono risolvere degli indovinelli: la risposta di ogni indovinello è il titolo di un libro. 
                            l'dea è che legge 'indovinello, trova il libro, legge il secondo indovinello, trovadeve il secondo libro e così via.
                            Quando arriva all'ultimo libro si apre lo scompartimento in cui è inserita la chiave. 
                cortile: descrivere meglio la descrizione del cortile. non ci sono azioni da compiere.
                x cucina             
                x soggiorno
                stanza crollata: aggiungere oggetto chiave
                armeria: gestire l'utilizzo delle varie armi 
                anticamere: se avanza tempo fare il comando unisci altrimenti le lenzuola si trovano già annodate e gestire l'arrampicata dul balcone.
                camera da letto figlia
                camera da letto figlio
                bagno 2: se avanza tempo mettere fantasma
                camera padronale: gestire gli oggetti nella stanza (spada e forse altro - vedi file descrizione stanze)
                balcone camera padronale: se avana tempo gestire l'arrampicata
                balcone anticamera: se avana tempo gestire l'arrampicata
                studio: vedere se stanno gli oggetti necessari
                torre: gestire dialoghi, , combattimento e fine gioco
                corridoio al secondo piano: gestire l'apertura della porta segreta con il movimento della statua
            se avanza tempo fare il comando "usa" per rampino, lenzuola ecc
            se avanza tempo Modificare mappe in maniera da renderle più precise
            qualcosa per le restful o socket: un'idea è quella di trovare un servizio che ci generi nomi di libri, da aggiungere
                                              nella bibblioteca, giusto per avere più libri
            modificare lo scroll in maniera che faccia sempre vedere l'ultima riga
            gestire l'aperture delle porte chiuse con le chiavi e le varie porte chiuse tra le stanze
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
            se avanza tempo gestire unico bottone mappa che visualizza la mappa del piano in cui ci si trova
            suddivisione progetto in più package*/
}
/*TODO: Stanze fatte:   Dispensa
                        Ingresso
                        scale
                        ripostiglio
                        sala da pranzo
                        vuoto: la morte
                        bagno*/