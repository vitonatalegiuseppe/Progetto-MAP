/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import java.util.List;
import java.util.Random;

/**
 *
 * @author giuse
 */
public class Controller {

    public Controller() {
    }

    public boolean doorcontroller(Room currentRoom, Room nextRoom) {
        boolean stato = true;
        ObjectAdv porta = new ObjectAdv(-2);

        for (ObjectAdv o : currentRoom.getObjects()) {
            for (ObjectAdv b : nextRoom.getObjects()) {
                if (o.equals(b)) {
                    if (!porta.isOpen()) {
                        return stato = false;
                    } else {
                        return stato;
                    }
                }
            }
        }
        return stato;
    }

    public boolean personHit() {

        boolean hit = false;
        Random rand = new Random();

        hit = rand.nextBoolean();

        return hit;
    }

    public String consequenceOfHurl(ObjectAdv objectHurled, Room currentRoom, List<ObjectAdv> inv) {
        String message = null;
        if (!objectHurled.getFragile()) {
            currentRoom.getObjects().add(objectHurled);
            message = "L'oggetto " + objectHurled.getName() + " non si è distrutto a seguito dello schianto.";
        }else{
            message = "L'oggetto " + objectHurled.getName() + " si è distrutto a seguito dello schianto.";
        }
        inv.remove(objectHurled);
        
        return message;
    }
}
