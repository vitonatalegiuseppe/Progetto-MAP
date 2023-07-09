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

    public boolean doorController(Room currentRoom, Room nextRoom) {
        boolean stato = true;

        for (ObjectAdv o : currentRoom.getObjects()) {
            for (ObjectAdv b : nextRoom.getObjects()) {
                if (o.equals(b)) {
                    if (!b.isOpen()) {
                        return stato = false;
                    } else {
                        return stato;
                    }
                }
            }
        }
        return stato;
    }

    public boolean objectHit() {

        boolean hit;
        Random rand = new Random();

        hit = rand.nextBoolean();

        return hit;
    }

    public boolean consequenceOfHurl(ObjectAdv objectHurled, Room currentRoom, List<ObjectAdv> inv) {
        boolean destroyed = false;
        if (objectHurled.getFragile()) {
            destroyed = true;
            if (objectHurled instanceof ObjectAdvContainer) {
                ObjectAdvContainer c = (ObjectAdvContainer) objectHurled;
                currentRoom.getObjects().addAll(c.getList());
            }
        } else {
            currentRoom.getObjects().add(objectHurled);
            destroyed = false;
        }
        inv.remove(objectHurled);

        return destroyed;
    }

//TODO: sistemare sotto come sopra
    public String consequenceOfHit(ObjectAdv objectHit, ObjectAdv strikingObject, Room currentRoom, List<ObjectAdv> inv) {
        String message = null;

        if (objectHit != null && strikingObject != null) {
            if (objectHit.getFragile() && strikingObject.getFragile()) {
                currentRoom.getObjects().remove(objectHit);
                inv.remove(strikingObject);
                message = "Nell'urto entrambi gli oggetti sono andati distrutti.";
            } else if (objectHit.getFragile()) {
                currentRoom.getObjects().remove(objectHit);
                message = "Nell'urto " + objectHit.getName() + " è adato distrutto.";
            } else {
                inv.remove(strikingObject);
                message = "Nell'urto " + strikingObject.getName() + " è adato distrutto.";
            }
        } else if (objectHit != null) {
            if (objectHit.getFragile()) {
                currentRoom.getObjects().remove(objectHit);
                message = "Nell'urto " + objectHit.getName() + " è adato distrutto.";
            }
        } else if (strikingObject != null) {
            if (strikingObject.getFragile()) {
                inv.remove(strikingObject);
                message = "Nell'urto " + strikingObject.getName() + " è adato distrutto.";
            }
        }

        return message;
    }
}
