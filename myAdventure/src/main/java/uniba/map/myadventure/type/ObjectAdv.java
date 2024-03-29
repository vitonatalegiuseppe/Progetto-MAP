
package uniba.map.myadventure.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giuse
 */
public class ObjectAdv {
    
    private final int id;

    private String name;

    private String description;
    
    private Set<String> alias;
    
    private boolean pickupable = true;

    private boolean openable = false;

    private boolean open = false;
    
    private boolean pushable = false;

    private boolean push = false;
    
    private boolean fillable = false;
    
    private boolean filled = false;
    
    private boolean fragile = false;
    
    private boolean visible = true;
    
    public ObjectAdv(int id) {
        this.id = id;
    }

    public ObjectAdv(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectAdv(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ObjectAdv(int id, String name, String description, Set<String> alias) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
    }
    
    public ObjectAdv(int id, String nome, String descrizione, Set<String> aliasSet, boolean openable, boolean pickupable, boolean pushable, boolean aperto, boolean push, boolean fillable, boolean filled, boolean fragile, boolean visible) {
        this.id = id;
        this.name = nome;
        this.description = descrizione;
        this.alias = aliasSet;
        this.openable = openable;
        this.pickupable = pickupable;
        this.pushable = pushable;
        this.open = aperto;
        this.push = push;
        this.fillable = fillable;
        this.filled = filled;
        this.fragile = fragile;
        this.visible = visible;
    }

    public String getName() {
        return name;
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

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isPushable() {
        return pushable;
    }

    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    public int getId() {
        return id;
    }
    
    public boolean isFillable() {
        return fillable;
    }

    public void setFillable(boolean fillable) {
        this.fillable = fillable;
    }
    
    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public boolean getFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    public boolean equals(ObjectAdv obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjectAdv other = (ObjectAdv) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
