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
    private GameFrame frame = null;
    
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
        frame.dispose();
        System.exit(0);
    }

    public void update(Observable o, Object arg) {
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ClassicGame")){
            gameModel = new ClassicModel();
            gameModel.addObserver(this);
            
            ClassicView v = new ClassicView((ClassicModel)gameModel);
            v.addPropertyChangeListener(this);
            
            frame.setGamePanel(v);
            frame.showGameBoard();
            //gameView = new ClassicView();
        }
        else if(evt.getPropertyName().equals("CampaignGame")){
            gameModel = new CampaignModel();
            gameModel.addObserver(this);
            
            CampaignView v = new CampaignView((CampaignModel)gameModel);
            v.addPropertyChangeListener(this);
            
            frame.setGamePanel(v);
            frame.showGameBoard();
        }
        else if(evt.getPropertyName().equals("ExitGame")){
            exitProgram();
        }
        else if(evt.getPropertyName().equals("MainMenu")){
            gameModel.pauseGame(true);
            frame.showGameMenu();
        }
    }
}
