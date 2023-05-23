/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 *
 * @author giuse
 */
public class ObjectContainer extends Object{
    
    private List<Object> list = new ArrayList<>();

    public ObjectContainer(int id) {
        super(id);
    }

    public ObjectContainer(int id, String name) {
        super(id, name);
    }

    public ObjectContainer(int id, String name, String description) {
        super(id, name, description);
    }

    public ObjectContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void add(Object o) {
        list.add(o);
    }

    public void remove(Object o) {
        list.remove(o);
    }
    
}
