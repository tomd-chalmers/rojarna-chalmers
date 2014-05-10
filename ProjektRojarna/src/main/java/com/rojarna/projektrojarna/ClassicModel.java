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
    private GameState state;
    
    public enum GameState{
        PLAYING, PAUSED, GAMEWON, GAMELOST;
    }
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, heigth));
        setGameState(GameState.PLAYING);
        
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
            Save.saveClassic(getMines());
            setGameState(GameState.GAMEWON);
        } else{
            getBoard().showMines();
            setGameState(GameState.GAMELOST);
        }
        
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
        //super.pauseGame(pause);
        
        if(pause && state == GameState.PLAYING){
            state = GameState.PAUSED;
            
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
    
    public void setGameState(GameState gameState){
        state = gameState;
    }
    
    public GameState getGameState(){
        return state;
    }
}
