/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;


/**
 *
 * @author Gaming
 * @revised Tom
 */
public class GameTimer{
    private long startTime=0;
    private boolean isRunning=false;
    private long stopTime=0;
    
    private void start(){
        startTime=System.currentTimeMillis();
        isRunning=true;
    } 
    
    private void stop(){
        stopTime=System.currentTimeMillis();
        isRunning=false;
    }
    
    // only some early thinking if u could create this class without threds.
}
