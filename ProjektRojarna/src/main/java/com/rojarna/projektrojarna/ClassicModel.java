/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;

/**
 *
 * @author Tobias
 * @revised Oskar
 */
public class ClassicModel extends AbstractGameModel{
    
    private GameTimer gameTimer = null;

    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    public void chooseSquare(int xPos, int yPos){
        
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            gameTimer = new GameTimer();
        }
        
        if( getBoard().chooseSquare(xPos, yPos) == Item.MINE){
            gameOver();
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        getBoard().markSquare(xPos, yPos);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void gameOver(){
        gameTimer.stop();
        
        //Save highscore!
        
        
    }

    @Override
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, heigth));
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void restartGame(){
        getBoard().reset();
        gameTimer.stop();
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
}
