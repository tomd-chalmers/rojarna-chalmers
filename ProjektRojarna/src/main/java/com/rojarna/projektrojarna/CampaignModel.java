/*
 * The Campaign game mode, will create its own gameboard and sets
 * the "rules" for this specific game mode.
 */

package com.rojarna.projektrojarna;

import java.beans.PropertyChangeEvent;


/**
 *
 * @author Joakim
 */
public class CampaignModel extends AbstractGameModel{
      
    private int mines, width, height, currentLives= 3, level = 1;
    private State gameState;
    
    public enum State{
        PLAYING,PAUSED,FINISHED,GAMEOVER;
    }
    public CampaignModel(){
        mines = 10;
        width = 8;
        height = 8;
        newGame(10,height,width);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(gameState.equals(State.PLAYING)){
            if(xPos < 0 || yPos < 0)
                throw new IllegalArgumentException();

            if(!getBoard().isClicked()){
                getGameTimer().start();
            }

            if(getBoard().getSquareMarking(xPos, yPos) != Square.Marking.FLAG){
                getBoard().chooseSquare(xPos, yPos);
                if(isMine(xPos,yPos)){
                    removeLife();
                }
                if(isLvlComplete()){
                    finishLevel();
                }
            }

            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public boolean isMine(int x, int y){
        return getSquare(x,y).getItem() == Square.Item.MINE;
    }
    
    private void removeLife(){
        if(currentLives > 0){
            currentLives--;
        }
        if(currentLives==0){
            gameOver();
        }
    }
    
     public void markSquare(int xPos, int yPos){
         if(gameState.equals(State.PLAYING)){
            if(xPos < 0 || yPos < 0)
               throw new IllegalArgumentException();

           getBoard().markSquare(xPos, yPos);

           this.setChanged();
           this.notifyObservers();
        }
     }
     
    public void usePowerup(PowerupInterface pu, int x, int y){
        if(getGameTimer().afford(pu.getCost())&&gameState.equals(State.PLAYING)){
            getGameTimer().removeTime(pu.getCost());
            
            if(!getBoard().isClicked()){
                getGameTimer().start();
            }
            
            pu.power(getBoard(), x, y);
            
            if(isLvlComplete()){
                finishLevel();
            }
            this.setChanged();
            this.notifyObservers();
        }
    }
     
     private void finishLevel(){
         if(getBoard().isAllNumberShown()){
             getGameTimer().stop();
             gameState = State.FINISHED;
             getBoard().showMines(true);

             this.setChanged();
             this.notifyObservers();
         }
     }
     public boolean isLvlComplete(){
         return getBoard().isAllNumberShown();
     }
     
    public void nextLevel(){
        if(gameState.equals(State.FINISHED)){
            level++;
            if(level<5){
                width=width+2;
                height=height+4;
            }
            mines = (int) ((int) (width*height)*(0.1+0.02*level));
            getGameTimer().addTime(120);
            newGame(mines,height,width);
        }
    }
    
    private void newGame(int mines, int height, int width) {
        if(mines < 0 || width < 0 || height < 0)
            throw new IllegalArgumentException();
        
        if(level == 1){
            setGameTimer(new GameTimer(120));
        }
        gameState = State.PLAYING;
        setBoard(new GameBoard(mines, height, width));
        
        this.setChanged();
        this.notifyObservers();
    }
    
    private void gameOver(){
        getGameTimer().stop();
        gameState = State.GAMEOVER;
        getBoard().showMines(true);
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public Square getSquare(int x, int y) {
        return getBoard().getSquare(x, y);
    }

    public int getLevel(){
        return level;
    }
    public int getLives(){
        return currentLives;
    }
    public boolean isGameOver(){
        return currentLives<1;
    }
    public State getState(){
        return gameState;
    }
    public void pauseGame(boolean paus){
        if(gameState.equals(State.PAUSED)||gameState.equals(State.PLAYING)){
            super.pauseGame(paus);   
            if(paus){
                gameState = State.PAUSED;
            }else{
                gameState = State.PLAYING;
            }
            this.setChanged();
            this.notifyObservers();
        }
    }
    public int getMines(){
        return mines;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("time")&&getGameTime()<=0){
            gameOver();
        }
        this.setChanged();
        this.notifyObservers();
    }
}
