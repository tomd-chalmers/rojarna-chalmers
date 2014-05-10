/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;

/**
 *
 * @author Tobias
 */
public abstract class AbstractGameModel extends Observable implements PropertyChangeListener{
    private GameBoard gameBoard;
    private GameTimer gameTimer;
    
    private boolean gamePaused = false;
    
    //Ha timer här istället så pausa metoden kan vara här?
    
    // Dock ska väll paus i campaign disabla powerups och grejer? eller mena du bara
    // att ha metodhuvudet här?
    
    //public abstract void gameOver(boolean gameWon);
    
    public abstract void chooseSquare(int x, int y);
    public abstract void markSquare(int x, int y);
    public abstract Square getSquare(int x, int y);
    
    public GameBoard getBoard(){
        return gameBoard;
    }
    
    public void setBoard(GameBoard board){
        gameBoard = board;
    }
    
    public int getWidth(){
        return getBoard().getWidth();
    }
    
    public int getHeight(){
        return getBoard().getHeight();
    }
    
    public int getMines(){
        return getBoard().getMines();
    }
    
    public void pauseGame(boolean b){
        if(b){
            gameTimer.stop();
            gamePaused = true;
        } else {
            gameTimer.start();
            gamePaused = false;
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public boolean isGamePaused(){
        return gamePaused;
    }
    
    public GameTimer getGameTimer(){
        return gameTimer;
    }
    
    public void setGameTimer(GameTimer g){
        gameTimer = g;
        gameTimer.addPropertyChangeListener(this);
    }
    
    public int getGameTime(){
        return gameTimer.getTimeSec();
    }
    
    public String getGameTimeString(){
        return gameTimer.getTimeMin();
    }
    
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("time")){
            this.setChanged();
            this.notifyObservers();
        }
    }
}

