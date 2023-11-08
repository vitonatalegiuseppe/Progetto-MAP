/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package uniba.map.myadventure.classes;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author giuse
 */
public class Room {
    
    private final int id;
    
    private String name;
    
    private String description;
    
    private String look = null;
    
    private boolean visible = true;
    
    private Room south = null;
    
    private Room north = null;
    
    private Room east = null;
    
    private Room west = null;
    
    private Room comeUp = null;
    
    private Room goDown = null;
    
    private final List<ObjectAdv> objects = new ArrayList<>();
    
    
    public Room(int id) {
        this.id = id;
    }
    
    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public Room getSouth() {
        return south;
    }
    
    public void setSouth(Room south) {
        this.south = south;
    }
    
    public Room getNorth() {
        return north;
    }
    
    public void setNorth(Room north) {
        this.north = north;
    }
    
    public Room getEast() {
        return east;
    }
    
    public void setEast(Room east) {
        this.east = east;
    }
    
    public Room getWest() {
        return west;
    }
    
    public void setWest(Room west) {
        this.west = west;
    }
    
    public Room getComeUp() {
        return comeUp;
    }
    
    public void setComeUp(Room comeUp) {
        this.comeUp = comeUp;
    }
    
    public Room getGoDown() {
        return goDown;
    }
    
    public void setGoDown(Room goDown) {
        this.goDown = goDown;
    }
    
    public String getLook() {
        return look;
    }
    
    public void setLook(String look) {
        this.look = look;
    }
    
    public List<ObjectAdv> getObjects() {
        return objects;
    }
    
    public List<AdvPerson> getPersonInRoom(){
        List<AdvPerson> listPersonInRoom = new ArrayList<>();
        if(!this.getObjects().isEmpty()){
            for(ObjectAdv o : this.getObjects()){
                if(o instanceof AdvPerson){
                    listPersonInRoom.add((AdvPerson) o);
                }
            }
        }
        
        return listPersonInRoom;
    }
    
    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        return this.id == other.id;
    }
    
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }
    
    public void changePersonStatus(boolean live){
        for(AdvPerson p : this.getPersonInRoom()){
            p.setLive(live);
        }
    }
    
    public void startInitiativePearsons(){
        for(AdvPerson p : this.getPersonInRoom()){
            (new Thread(p)).start();
        }
    }
    
    public Room changeRoom(String direction, Room room){
        Controller controller = new Controller();
        Room newRoom = null;
        switch (direction){
            case "North": newRoom = room.getNorth(); break;
            case "South": newRoom = room.getSouth(); break;
            case "East": newRoom = room.getEast(); break;
            case "West": newRoom = room.getWest(); break;
            case "comeUp": newRoom = room.getComeUp(); break;
            case "goDown": newRoom = room.getGoDown(); break;
        }
        
        if (newRoom != null){
            if (controller.doorController(room, newRoom)) {
                room.changePersonStatus(false);
                Engine2.appendToScreenEngine(newRoom.getName());
                Engine2.appendToScreenEngine("================================================");
                Engine2.appendToScreenEngine(newRoom.getDescription());
                newRoom.changePersonStatus(true);
                newRoom.startInitiativePearsons();
            } else {
                Engine2.appendToScreenEngine("Sembra che la porta sia chiusa. per aprirla devi avere nell'inventario la chiave giusta. \nAdesso non la hai.");
                newRoom = room;
            }
        }else{
            Engine2.appendToScreenEngine("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
            newRoom = room;
        }
        
        return newRoom;
    }
}
