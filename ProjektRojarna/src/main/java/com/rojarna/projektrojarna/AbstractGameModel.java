/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.Observable;

/**
 *
 * @author Tobias
 */
public abstract class AbstractGameModel extends Observable{
    private GameBoard gameBoard;
    
    private boolean gamePaused = false;
    
    //Ha timer här istället så pausa metoden kan vara här?
    
    // Dock ska väll paus i campaign disabla powerups och grejer? eller mena du bara
    // att ha metodhuvudet här?
    
    public abstract void newGame(int mines, int width, int heigth);
    //public abstract void gameOver(boolean gameWon);
    
    public abstract void chooseSquare(int x, int y);
    public abstract void markSquare(int x, int y);
    public abstract Square getSquare(int x, int y);
    
    public GameBoard getBoard(){
        return gameBoard;
    }
    
    public boolean getGamePaused(){
        return gamePaused;
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
}
