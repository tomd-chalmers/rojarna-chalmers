/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rojarna.projektrojarna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


/**
 *
 * @author Tobias
 * @revised Tom
 * @revised Tobias
 */
public class GameTimer extends Timer{
    private boolean descendingTime = false;
    
    private int     timeLeft = 0;
    
    // Timern från java.swing.Timer körs tydligen i samma tråd som alla andra
    // swing objekt, så detta borde vara optimalt att använda tillsammans med
    // GUI:n enligt de källor jag kollat.
    
    // Sedan vet jag inte om vi borde extend:a eller endast ha en referens
    // till en Timer i klassen så båda ligger här just nu.
    private Timer gameTimer = null;
    
    
    
    //private List<ActionListener> timerListeners = new ArrayList<ActionListener>();
    
    
    
    public GameTimer(int delay, ActionListener listener){
        super(delay, listener);
        //gameTimer = new Timer(delay, listener);
        
        //timerListeners.add(listener);
    }
}
