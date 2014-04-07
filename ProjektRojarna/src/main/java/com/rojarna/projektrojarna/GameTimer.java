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
 */
public class GameTimer {
    
    private boolean isRunning=false;
    private boolean dec = false;
    private int time = 0;
    private static int SEC = 1000;
    
    private final Timer timer = new Timer(SEC, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isRunning){
                    if(dec){
                        time--;
                        // fire property change or something, for a view.
                    }else{
                        time++;
                        // fire property change or something, for a view.
                    }
                }else{
                    // do nothing...
                }
            }
        });
    
        
    public GameTimer(){
        isRunning = true;
        timer.start();  //use method to start?
    }
    
    public GameTimer(int time){
        this.time=time;
        isRunning = true;
        dec = true;
        timer.start(); //use method to start?
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
    
    public void pause(){
        isRunning=false;
    }
    public void unPause(){
        isRunning=true;
    }
    
    public boolean afford(int a){
        return time>a;
    }
    
    public void removeTime(int a){
        if(afford(a)){
            time=time-a;
        }
        else{
            //cant afford, do stuff?
        }
    }
    
    public void addTime(int a){
        this.time=time+a;
    }
    
    
    public void Start(){  // needed? or start in construktor.
        timer.start();
    }
}