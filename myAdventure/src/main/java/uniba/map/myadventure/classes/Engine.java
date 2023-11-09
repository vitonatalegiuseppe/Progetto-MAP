/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import uniba.map.myadventure.type.ObjectAdv;
import uniba.map.myadventure.type.Room;
import uniba.map.myadventure.parser.Parser;
import uniba.map.myadventure.parser.ParserOutput;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import uniba.map.myadventure.interfaces.Grafica;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import uniba.map.myadventure.storage.DatabaseManagement;
import uniba.map.myadventure.interfaces.StartGame;

/**
 *
 * @author giuse
 */
public class Engine {

    private final GameDescription game;

    private Parser parser;
    
    private static Grafica grafica;
    
    private boolean utenteExiste;
    
    public Engine(GameDescription game, Grafica grafica) {
        this.game = game;
        this.grafica = grafica;
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

    public boolean isUtenteExiste() {
        return utenteExiste;
    }

    public void setUtenteExiste(boolean UtenteExiste) {
        this.utenteExiste = UtenteExiste;
    }
    
    public static Grafica getGrafica() {
        return grafica;
    }

    public static void setGrafica(Grafica grafica) {
        Engine.grafica = grafica;
    }
    
    public static void appendToScreenEngine(String text) {
        grafica.appendToScreen(text);
    }

    public void inizialized() {
        DatabaseManagement databaseManagement = new DatabaseManagement();
        String savedPosition = databaseManagement.getRoomNamePosition();
         
        grafica.appendToScreen("================================ ");
        grafica.appendToScreen("* Adventure Castle Game v. 0.3 - 2022-2023 * ");
        grafica.appendToScreen("================================ ");
        
        if (utenteExiste == true){
            // Ottieni la lista di oggetti utente
            List<ObjectAdv> oggettiUtenti = databaseManagement.getOggettiUtente();
            game.getInventory().addAll(oggettiUtenti);
            
            // Recupera la stanza da dove riparte l'utente
            for (Room room : game.getRooms()) {
                if (room.getName().equalsIgnoreCase(savedPosition)) {
                    game.setCurrentRoom(room);
                }
            }
        }
        
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
    public void start() {
        StartGame startGame = new StartGame(grafica.getEngine());
        
        startGame.setVisible(true);
        
        // WindowListener per attendere la chiusura di StartGame
        startGame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                grafica.setVisible(true);
                inizialized();
            }
        });    
    }
