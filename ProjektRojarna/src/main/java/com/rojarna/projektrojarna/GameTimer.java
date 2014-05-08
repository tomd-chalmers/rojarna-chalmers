/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rojarna.projektrojarna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 * @author Tobias
 * @revised Tom
 * @revised Tobias
 * @revised (redone) Tom
 */
public class GameTimer {
    
    private final static int SEC = 1000;
    
    private final int startValue;
    private boolean dec;
    private int time;
    
    private final Timer timer = new Timer(SEC, new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            if(dec){
                time--;
                // fire property change or something, for a view.
            }else{
                time++;
                // fire property change or something, for a view.
            }
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
        //if(afford(a)){
            time=time-a;
        //}
        //else{
            //cant afford, do stuff?
        //}
    }
    
    public void addTime(int a){
        this.time=time+a;
    }
    
    public void start(){
        timer.start();
    }
    
    // resets the timer, also stops the timer.
    public void reset(){
        timer.stop();
        time=startValue;
    }
}