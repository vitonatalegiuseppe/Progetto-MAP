
package uniba.map.myadventure.parser;

import uniba.map.myadventure.parser.ParserOutput;
import java.util.List;
import java.util.Set;
import uniba.map.myadventure.type.Command;
import uniba.map.myadventure.type.ObjectAdv;
import uniba.map.myadventure.classes.Utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sensei Tequila
 */
public class Parser {
    private final Set<String> stopwords;

    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().toLowerCase().equals(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }
    
    private int checkForObject(String token, List<ObjectAdv> obejcts) {
        for (int i = 0; i < obejcts.size(); i++) {
            if (obejcts.get(i).getName().toLowerCase().equals(token) || obejcts.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }
    
    public ParserOutput parse(String command, List<Command> commands, List<ObjectAdv> objects, List<ObjectAdv> inventory) {
        List<String> tokens = Utils.parseString(command, stopwords);
        int ioinv = -1;
        int ic = -1;
        int io = -1;
        
        if (!tokens.isEmpty()) {
            ic = checkForCommand(tokens.get(0), commands);
            if (ic > -1) {
                if (tokens.size() > 1) {
                    io = checkForObject(tokens.get(1), objects);
                    if (io < 0 && tokens.size() > 2) {
                        io = checkForObject(tokens.get(2), objects);
                    }
                    ioinv = checkForObject(tokens.get(1), inventory);
                    if (ioinv < 0 && tokens.size() > 2) {
                        ioinv = checkForObject(tokens.get(2), inventory);
                    }
                    if (io > -1 && ioinv > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io), inventory.get(ioinv));
                    } else if (io > -1) {
                        return new ParserOutput(commands.get(ic), objects.get(io), null);
                    } else if (ioinv > -1) {
                        return new ParserOutput(commands.get(ic), null, inventory.get(ioinv));
                    } else {
                        return new ParserOutput(commands.get(ic), null, null);
                    }
                } else {
                    return new ParserOutput(commands.get(ic), null);
                }
            } else {
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }
}