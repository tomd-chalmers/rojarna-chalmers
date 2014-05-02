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
    
    private GameTimer gameTimer = null;
    
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
            gameTimer = new GameTimer();
            gameTimer.start();
        }
        
        getBoard().chooseSquare(xPos, yPos);
        isMine(xPos,yPos);
        isLvlComplete();
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void isMine(int x, int y){
        if(getSquare(x,y).getItem() == Square.Item.MINE){
            if(currentLives > 0){
                currentLives -= 1;
            } else {
                gameOver(false);
            }
        }
    }
    
     public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        getBoard().markSquare(xPos, yPos);
        
        this.setChanged();
        this.notifyObservers();
     }
     
     public void isLvlComplete(){
         if(getBoard().isAllNumberShown()){
             gameTimer.stop();
             nextLevel();
             
             this.setChanged();
             this.notifyObservers();
         }
     }
     
    public void nextLevel(){
        level++;
        width++;
        height++;
        mines = ;//....
        newGame(mines,width,height);
    }
    
    @Override
    public void newGame(int mines, int width, int height) {
        if(mines < 0 || width < 0 || height < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, height));
        
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void gameOver(boolean gameWon) {
        // Boolean i just campaign kanske inte behövs...
    }

    @Override
    public Square getSquare(int x, int y) {
        return getBoard().getSquare(x, y);
    }
    
}
