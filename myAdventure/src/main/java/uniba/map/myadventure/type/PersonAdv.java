/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uniba.map.myadventure.type;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import uniba.map.myadventure.classes.Engine;

/**
 *
 * @author giuse
 */
public class PersonAdv extends ObjectAdvContainer implements Runnable{
    
    private int life = 0;
    
    private boolean live = false;
    
    private static int playerLife = 15;
    
    public PersonAdv(int id, int life) {
        super(id);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, int life) {
        super(id, name);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, String description, int life) {
        super(id, name, description);
        this.life = life;
    }
    
    public PersonAdv(int id, String name, String description, Set<String> alias, int life) {
        super(id, name, description, alias);
        this.life = life;
    }
    
    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
        if(this.life == 0)
            this.setLive(false);
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
        PersonAdv.playerLife = playerLife;
        
        if(getPlayerLife() == 0){
            System.exit(0);
        }
    }
    
    public void attack(){
        if(this.isLive()){
            setPlayerLife(playerLife-1);
            Engine.appendToScreenEngine("Sei stato colpito. La tua vita è pari a: " + getPlayerLife());
        }
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        while(this.isLive()){
            try {
                // Metti il programma in pausa per 10 secondi
                TimeUnit.SECONDS.sleep(20);
                this.attack();
            } catch (InterruptedException e) {
                // Gestisci eventuali eccezioni dovute all'interruzione del sonno
                System.err.println(e.getCause()+ ": " + e.getMessage());
            } 
        }
    }
}

