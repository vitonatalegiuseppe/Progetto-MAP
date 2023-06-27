/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

/**
 *
 * @author giuse
 */
public class Controller {
   
    public static boolean doorcontroller(Room currentRoom, Room nextRoom){
        boolean stato = true;
        ObjectAdv porta = new ObjectAdv(-2);
       
        for(ObjectAdv o: currentRoom.getObjects()){
            if(o.getId()== currentRoom.getId()){
                porta = o;
            }  
        }
        
        for(ObjectAdv o: nextRoom.getObjects()){
            if(o.getId()== nextRoom.getId()){
                porta = o;
            }  
        }
        
        if(!porta.isOpen()){
            stato = false;
            System.out.println("sembra che la porta sia chiusa, percaso ti ritrovi qualche chiave nell'inventario?");
        }
        
        return stato;
    }

}
