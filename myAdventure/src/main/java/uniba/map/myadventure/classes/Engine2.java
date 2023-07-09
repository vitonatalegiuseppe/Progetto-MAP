/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
        grafica.appendToScreen(game.getCurrentRoom().getDescDay());
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

    /**
     * @param args the command line arguments
     */
    /*  public static void main(String[] args) {
        Engine2 engine = new Engine2(new AdventureCastleGame());
        engine.execute();
        
    }*/
//jhbfgjhkjnkm,
}
