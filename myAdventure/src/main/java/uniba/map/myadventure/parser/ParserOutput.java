/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uniba.map.myadventure.parser;

import uniba.map.myadventure.type.Command;
import uniba.map.myadventure.type.ObjectAdv;

/**
 *
 * @author Sensei Tequila
 */
public class ParserOutput {
    private Command command;

    private ObjectAdv object;
    
    private ObjectAdv invObject;

    public ParserOutput(Command command, ObjectAdv object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, ObjectAdv object, ObjectAdv invObejct) {
        this.command = command;
        this.object = object;
        this.invObject = invObejct;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public ObjectAdv getObject() {
        return object;
    }

    public void setObject(ObjectAdv object) {
        this.object = object;
    }

    public ObjectAdv getInvObject() {
        return invObject;
    }

    public void setInvObject(ObjectAdv invObject) {
        this.invObject = invObject;
    }
}
