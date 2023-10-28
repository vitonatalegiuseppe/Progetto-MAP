/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniba.map.myadventure.classes.SeAvanzaTempo;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import uniba.map.myadventure.classes.ObjectAdv;
import uniba.map.myadventure.interfaces.Grafica;

/**
 *
 * @author Sensei Tequila
 */

/*TODO: se avanza tempo creare una classe oggetti generale da cui ereditano le persone e gli oggetti dell'avventura.
dalla classe oggettiADv eredita la classe oggetti contenitore. nella classe oggetti ci mettiamo solo l'id, l'equals e ghash code
nella classe oggettiAdv mettiamo tutti gli attributi degli oggetti, in person solo quelli relativi alle persone.*/


public class PersonAdv extends ObjectAdv implements Runnable {
    
    private int life = 0;
    
    private boolean live = false;
    
    Grafica screen = new Grafica();
    
    public PersonAdv(int id, int life){
        super(id);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, int life){
        super(id, name);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, String description, int life){
        super(id, name, description);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, String description, Set<String> alias, int life){
        super(id, name, description, alias);
        this.life = life;
    }
    
    public int getLife(){
        return life;
    }
    
    public void setLife(int life){
        this.life = life;
    }
    
    public boolean isLive(){
        return live;
    }
    
    public void setLive(boolean live){
        this.live = live;
    }
    
    public void reduceLife(){
        this.setLife(this.life-1);
    }
    
    public void incrementLife(){
        this.setLife(this.life+1);
    }
    
    public void attack(PersonAdv person){
        person.reduceLife();
        screen.appendToScreen("Sei stato colpito da pinco panco...");
        //TODO: vedere se serve o no
    }

    @Override
    public void run() {
        while(this.isLive()){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PersonAdv.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.attack(new PersonAdv(155, 155));
        }
    }
}