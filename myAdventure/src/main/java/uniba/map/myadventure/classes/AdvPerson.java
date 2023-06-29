/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes;

import java.util.Set;

/**
 *
 * @author giuse
 */
public class AdvPerson extends ObjectAdvContainer {
       
  private int life = 0;
  
   
    public AdvPerson(int id, String name, int life) {
        super(id, name);
        this.life = life;
    }

    public AdvPerson(int id, String name, int life,String description) {
        super(id, name, description);
        this.life = life;
    }

    public AdvPerson(int id, String name,int life, String description, Set<String> alias ) {
        super(id, name, description, alias);
        this.life = life;
    }
    
    public int getLife(){
        return life;
    }
    
    public  void setLife(int life){
        this.life = life;
    }
    
    

   
    
}
