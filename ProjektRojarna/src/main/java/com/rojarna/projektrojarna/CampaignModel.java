/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Joakim
 */
public class CampaignModel extends AbstractGameModel{
      
    private int mines, width, height, currentLives= 3, level = 1;
    
    public enum state{
        PLAYING,BETWEEN,GAMEOVER;
    }
    
    public CampaignModel(){
        mines = 10;
        width = 8;
        height = 8;
        newGame(10,8,8);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            getGameTimer().start();
        }
        
        if(getBoard().getSquareMarking(xPos, yPos) != Square.Marking.FLAG){
            getBoard().chooseSquare(xPos, yPos);
            if(isMine(xPos,yPos)){
                removeLive();
            }
            if(isLvlComplete()){
                finishLevel();
            }
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public boolean isMine(int x, int y){
        return getSquare(x,y).getItem() == Square.Item.MINE;
    }
    
    public void removeLive(){
        if(currentLives > 0){
            currentLives -= 1;
        } else {
            gameOver();
        }
    }
    
     public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        getBoard().markSquare(xPos, yPos);
        
        this.setChanged();
        this.notifyObservers();
     }
     
    public void usePowerup(PowerupInterface pu, int x, int y){
        //Bättre att ha koll på om den har råd här istället för i getCost?
        if(getGameTimer().afford(pu.getCost())){
            getGameTimer().removeTime(pu.getCost());
            pu.power(getBoard(), x, y);
            this.setChanged();
            this.notifyObservers();
        }
    }
     
     public void finishLevel(){
         if(getBoard().isAllNumberShown()){
             getGameTimer().stop();
             //nextLevel();
             
             this.setChanged();
             this.notifyObservers();
         }
     }
     public boolean isLvlComplete(){
         return getBoard().isAllNumberShown();
     }
     
    public void nextLevel(){
        level++;
        width=width+2;
        height=height+2;

        mines = (int) ((int) (width*height)*(0.1+0.05*level));
        getGameTimer().addTime(120);
        newGame(mines,width,height);
    }
    
    @Override
    public void newGame(int mines, int width, int height) {
        if(mines < 0 || width < 0 || height < 0)
            throw new IllegalArgumentException();
        
        if(level == 1){
            setGameTimer(new GameTimer(120));
        }
        
        setBoard(new GameBoard(mines, width, height));
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void gameOver(){
        getGameTimer().stop();
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
    
}
