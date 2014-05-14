/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Tobias
 */
public class GameController implements Observer, PropertyChangeListener{
    
    private AbstractGameModel gameModel = null;    
    private GameFrame frame = null;
    private MenuPanel panel = null;
    
    public GameController(){
        frame = new GameFrame();
        
        frame.setVisible(true);
        frame.pack();
        frame.addPropertyChangeListener(this);
    }
    
    public GameController(AbstractGameModel model){
        gameModel = model;
        model.addObserver(this);
    }
    
    private void exitProgram(){
        frame.setEnabled(false);
        System.exit(0);
    }

    public void update(Observable o, Object arg) {
        System.out.println("Served!");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ClassicGame")){
            ClassicModel m = new ClassicModel();
            m.addObserver(this);
            
            ClassicView v = new ClassicView(m);
            
            frame.setGamePanel(v);
            frame.showGameBoard();
            //gameView = new ClassicView();
        }
        else if(evt.getPropertyName().equals("CampaignGame")){
            CampaignView v = new CampaignView();  
            frame.setGamePanel(v);
            frame.showGameBoard();
        }
        else if(evt.getPropertyName().equals("ClassicGame")){
            exitProgram();
        }
    }       
}
