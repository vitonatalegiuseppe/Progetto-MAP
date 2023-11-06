/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author giuse
 */
public class ObjectAdvContainer extends ObjectAdv {

    private List<ObjectAdv> list = new ArrayList<>();

    public ObjectAdvContainer(int id) {
        super(id);
    }

    public ObjectAdvContainer(int id, String name) {
        super(id, name);
    }

    public ObjectAdvContainer(int id, String name, String description) {
        super(id, name, description);
    }

    public ObjectAdvContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

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

    public List<ObjectAdv> showObjectContained() {
        Iterator<ObjectAdv> it = this.getList().iterator();
        if (!this.getList().isEmpty()) {
            Engine2.appendToScreenEngine(this.getName() + " ha i seguenti oggetti: ");
            while (it.hasNext()) {
                ObjectAdv next = it.next();
                if (next.isVisible()){
                    Engine2.appendToScreenEngine(next.getName() + ", ");
                }
                it.remove();
            }
            Engine2.appendToScreenEngine("\n");
        }
        return null;
    }
}
