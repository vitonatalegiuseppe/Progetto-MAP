/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uniba.map.myadventure.classes;

import uniba.map.myadventure.interfaces.Grafica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giuse
 */
public abstract class GameDescription {
    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<ObjectAdv> inventory = new ArrayList<>();

    private Room currentRoom;

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<ObjectAdv> getInventory() {
        return inventory;
    }

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, Grafica grafica);

}
