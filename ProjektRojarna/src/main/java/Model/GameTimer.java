/**
 * The gameTimer uses the (util)Timer to make a counter tick either 
 * from zero and upp or from a given start value and down.
 * It also has a ot of funktion to help gameModels to easy add and reduce time
 * from the counter, to make the GameTimer more versatile.
 * 
 * @author Tobias
 * @revised Tom
 * @revised Tobias
 * @revised (redone) Tom
 */
package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.Timer;


public class GameTimer {
    
    private final PropertyChangeSupport property = new PropertyChangeSupport(this);
    
    private final static int SEC = 1000;
    
    private final int startValue;
    private boolean dec;
    private int time;
    
    private final Timer timer = new Timer(SEC, new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(dec){
                time--;
            }else{
                time++;
            }
            property.firePropertyChange("time",true,false);
        }
    });
    
        
    public GameTimer(){
        startValue = 0;
        dec = false;
        time = 0;
    }
    
    public GameTimer(int time){
        this.time=time;
        dec = true;
        startValue = time;
    }
    
    
    public int getTimeSec(){
        return time;
    }
    
    // giving the time in min
    public String getTimeMin(){
        int m = time/60;
        int s = time-(60*m);
        
        String min;
        String sec;
        
        if(m < 10){
            min = "0"+m;
        }else{
            min = ""+m;
        }
        if(s < 10){
            sec = "0"+s;
        }else{
            sec = ""+s;
        }
        return min+":"+sec;
    }
    
    public void stop(){
        this.timer.stop();
    }
    
    public boolean afford(int a){
        return time>a;
    }
    
    public void removeTime(int a){
            time=time-a;
    }
    
    public void addTime(int a){
        this.time=time+a;
    }
    
    public void start(){
        timer.start();
    }
    
    public void reset(){
        timer.stop();
        time=startValue;
    }
    
     public void addPropertyChangeListener(PropertyChangeListener l) {
         property.addPropertyChangeListener(l);
     }

     public void removePropertyChangeListener(PropertyChangeListener l) {
         property.removePropertyChangeListener(l);
     }
}