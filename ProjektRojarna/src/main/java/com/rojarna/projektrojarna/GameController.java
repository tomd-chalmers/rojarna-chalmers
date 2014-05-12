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
    private GameView gameView = null;
    
    private GameFrame frame = null;
    private MenuPanel panel = null;
    
    public GameController(){
        frame = new GameFrame();
        
        //frame.add(panel, "Menu");
        //((CardLayout)panel.getLayout()).show(frame.getContentPane(), "Menu");
        frame.setVisible(true);
        frame.pack();
        
        frame.addPropertyChangeListener("ClassicGame", this);
        frame.addPropertyChangeListener("CampaignGame", this);
        
        frame.addPropertyChangeListener("ExitGame", this);
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
        System.exit(0);
    }

    public void update(Observable o, Object arg) {
        System.out.println("Observed!");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("property has changed");
        
        if(evt.getPropertyName().equals("ClassicGame")){
            newGame(new ClassicModel(), new GameView());
            System.out.println("classic clicked");
        }
        else if(evt.getPropertyName().equals("CampaignGame")){
            newGame(new CampaignModel(), new GameView());
            System.out.println("campaign clicked");
        }
        else if(evt.getPropertyName().equals("ClassicGame")){
            exitProgram();
        }
    }
}
