/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author giuse
 */
public class Room {
    
   
    private final int id;

    private String name;

    private String descNight;
    
    private String descDay;

    private String look = "Non c'è nulla di interessante qui.";
    
    private boolean visible = true;

    private Room south = null;

    private Room north = null;

    private Room east = null;

    private Room west = null;
    
    private final List<Object> objects=new ArrayList<>();

    
    public Room(int id) {
        this.id = id;
    }

    public Room(int id, String name, String descDay, String descNight) {
        this.id = id;
        this.name = name;
        this.descDay = descDay;
        this.descNight = descNight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescDay() {
        return descDay;
    }

    public void setDescDay(String descDay) {
        this.descDay = descDay;
    }
    
    public String getDescNight() {
        return descNight;
    }

    public void setDescNight(String descNight) {
        this.descNight = descNight;
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
    
    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }
    
    public List<Object> getObjects() {
        return objects;
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

    
}
