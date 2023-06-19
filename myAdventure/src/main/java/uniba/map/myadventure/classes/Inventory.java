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
    
    public class Inventory {

    private List<ObjectAdv> list = new ArrayList<>();

    public List<ObjectAdv> getList() {
        return list;
    }

    public void setList(List<ObjectAdv> list) {
        this.list = list;
    }

    public void add(ObjectAdv o) {
        list.add(o);
    }

    public void remove(ObjectAdv o) {
        list.remove(o);
    }
}

    

