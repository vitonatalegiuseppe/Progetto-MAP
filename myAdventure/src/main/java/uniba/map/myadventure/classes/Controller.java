/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import java.util.Random;


/**
 *
 * @author giuse
 */
public class Controller {
    
    public Controller(){
        
    }

    public boolean doorcontroller(Room currentRoom, Room nextRoom) {
        boolean stato = true;
        ObjectAdv porta = new ObjectAdv(-2);

        for (ObjectAdv o : currentRoom.getObjects()) {
            for (ObjectAdv b : nextRoom.getObjects()) {
                if (o.equals(b)) {
                    if (!porta.isOpen()) {
                        return stato = false;
                    }else{
                        return stato;
                    }
                }
            }
        }
        return stato;
    }
    
    public boolean personHit(){
        
        boolean hit = false;
        Random rand = new Random();
        
        hit = rand.nextBoolean();

        return hit;
    }
    
   
}
