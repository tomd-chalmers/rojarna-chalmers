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
 * @revised Tom
 */
public class ClassicModel extends AbstractGameModel{

    private boolean gameOver = false;
    private boolean gamePaused = false;
    
    public enum state{
        PLAYING,GAMEOVER;
    }
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    @Override
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, heigth));
        
        setGameOver(false);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void chooseSquare(int xPos, int yPos){
        
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            setGameTimer(new GameTimer());
        }
        if( getBoard().chooseSquare(xPos, yPos) == Item.MINE){
            gameOver(false);
            pauseGame(true);
        } else if( getBoard().isAllNumberShown() ){
            gameOver(true);
            pauseGame(true);
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    public String getTime(){
        return gameTimer.getTimeMin();
    }
    
    public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        getBoard().markSquare(xPos, yPos);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void gameOver(boolean gameWon){
        getGameTimer().stop();
        
        if(gameWon){
            //Save highscore!
            System.out.println("YOU WON!");
        } else{
            getBoard().showMines();
            System.out.println("YOU LOST!");
        }
        
        setGameOver(true);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void restartGame(){
        getBoard().reset();
        getGameTimer().stop();
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void pauseGame(boolean pause){
        if(pause && !gamePaused){
            gamePaused = true;
            
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public void setGameOver(boolean gameIsOver){
        gameOver = gameIsOver;
    }
    
    public boolean getGameOver(){
        return gameOver;
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
}
