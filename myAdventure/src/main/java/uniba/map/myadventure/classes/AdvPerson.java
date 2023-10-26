/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uniba.map.myadventure.classes;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuse
 */
public class AdvPerson extends ObjectAdvContainer implements Runnable{
    
    private int life = 0;
    
    private boolean live = false;
    
    static private int playerLife = 10;
    
    public AdvPerson(int id, int life) {
        super(id);
        this.life = life;
    }
    
    public AdvPerson(int id, String name, int life) {
        super(id, name);
        this.life = life;
    }
    
    public AdvPerson(int id, String name, String description, int life) {
        super(id, name, description);
        this.life = life;
    }
    
    public AdvPerson(int id, String name, String description, Set<String> alias, int life) {
        super(id, name, description, alias);
        this.life = life;
    }
    
    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }
    
    public void setLive(boolean live) {
        this.live = live;
    }
    
    public boolean isLive() {
        return live;
    }
    
    public void reduceLife(){
        this.setLife(this.life-1);
    }
    
    public static int getPlayerLife() {
        return playerLife;
    }
    
    public static void setPlayerLife(int playerLife) {
        AdvPerson.playerLife = playerLife;
    }
    
    public void attack(){
        if(this.isLive()){
            setPlayerLife(playerLife-1);
            System.out.println("Sei stato colpito. La tua vita è pari a:" + getPlayerLife());
            //appendToScreen("Sei stato colpito. La tua vita è pari a:" + getPlayerLife());
            //TODO: DEVE DEIRE CHE ha colpito il giocatore
        }
    }
    
    @Override
    public void run() {
        while(this.isLive()){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AdvPerson.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.attack();
        }
    }
}

