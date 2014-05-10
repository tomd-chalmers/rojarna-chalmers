/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

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
    private GameView gameView = null;
    
    private GameFrame frame = null;
    
    public GameController(){
        frame = new GameFrame();
        
        frame.add(new MenuPanel());
        frame.addPropertyChangeListener(this);
        frame.setVisible(true);
        frame.pack();
    }
    
    public GameController(AbstractGameModel model, GameView view){
        gameModel = model;
        model.addObserver(this);
        
        gameView = view;
        view.setModel(model);
        view.pack();
    }
    
    private void newGame(AbstractGameModel model, GameView view){
        gameModel = model;
        model.addObserver(this);
        
        gameView = view;
        view.setModel(model);
        view.pack();
    }
    
    private void exitProgram(){
        
    }   

    public void update(Observable o, Object arg) {
        ;
    }
    


    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ClassicGame")){
            newGame(new ClassicModel(), new GameView());
        }
        else if(evt.getPropertyName().equals("CampaignGame")){
            newGame(new CampaignModel(), new GameView());
        }
        else if(evt.getPropertyName().equals("ClassicGame")){
            exitProgram();
        }
    }
}
