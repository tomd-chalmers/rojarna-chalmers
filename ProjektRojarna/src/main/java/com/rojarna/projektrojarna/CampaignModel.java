/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.beans.PropertyChangeEvent;

/**
 *
 * @author Joakim
 */
public class CampaignModel extends AbstractGameModel{
      
    private int mines, width, height, currentLives= 3, level = 1;
    private state gameState;
    
    public enum state{
        PLAYING,PAUSED,FINISHED,GAMEOVER;
    }
    public CampaignModel(){
        mines = 10;
        width = 8;
        height = 8;
        newGame(10,height,width);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(gameState.equals(state.PLAYING)){
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
         if(gameState.equals(state.PLAYING)){
            if(xPos < 0 || yPos < 0)
               throw new IllegalArgumentException();

           getBoard().markSquare(xPos, yPos);

           this.setChanged();
           this.notifyObservers();
        }
     }
     
    public void usePowerup(PowerupInterface pu, int x, int y){
        //Bättre att ha koll på om den har råd här istället för i getCost?
        if(getGameTimer().afford(pu.getCost())&&gameState.equals(state.PLAYING)){
            getGameTimer().removeTime(pu.getCost());
            
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
             gameState = state.FINISHED;
             //nextLevel();
             
             this.setChanged();
             this.notifyObservers();
         }
     }
     public boolean isLvlComplete(){
         return getBoard().isAllNumberShown();
     }
     
    public void nextLevel(){
        if(gameState.equals(state.FINISHED)){
            level++;
            width=width+2;
            height=height+2;

            mines = (int) ((int) (width*height)*(0.1+0.05*level));
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
        gameState = state.PLAYING;
        setBoard(new GameBoard(mines, height, width));
        
        this.setChanged();
        this.notifyObservers();
    }
    
    private void gameOver(){
        System.out.println("GameOver");
        getGameTimer().stop();
        gameState = state.GAMEOVER;
        //spara highscore
        //popup
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
        return currentLives>0;
    }
    public state getState(){
        return gameState;
    }
    public void pauseGame(boolean paus){
        if(gameState.equals(state.PAUSED)||gameState.equals(state.PLAYING)){
            //super.pauseGame(paus);   
            if(paus){
                gameState = state.PAUSED;
            }else{
                gameState = state.PLAYING;
            }
            this.setChanged();
            this.notifyObservers();
        }
    }
    public int getMines(){
        return mines;
    }
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("time")&&getGameTime()<=0){
            gameOver();
        }
        this.setChanged();
        this.notifyObservers();
    }
}
