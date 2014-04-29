/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Tobias
 */
public class GameController implements Observer{
    
    private AbstractGameModel gameModel = null;
    private GameView gameView = null;
    
    public GameController(AbstractGameModel model, GameView view){
        gameModel = model;
        model.addObserver(this);
        
        gameView = view;
        view.setModel(model);
    }
    

    public void update(Observable o, Object arg) {
        ;
    }
    
}
