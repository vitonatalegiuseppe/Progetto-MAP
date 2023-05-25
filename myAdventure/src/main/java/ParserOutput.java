/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sensei Tequila
 */
public class ParserOutput {
    private Command command;

    private Object object;
    
    private Object invObject;

    public ParserOutput(Command command, Object object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, Object object, Object invObejct) {
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getInvObject() {
        return invObject;
    }

    public void setInvObject(Object invObject) {
        this.invObject = invObject;
    }
}
