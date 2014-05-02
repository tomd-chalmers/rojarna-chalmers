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
    
    private final static int CAMPAIGN_LIVES = 3;
    
    private int mines, width, height, currentLives= 3;
    
    private GameTimer gameTimer = null;
    
    public CampaignModel(){
        newGame(10,8,8);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            gameTimer = new GameTimer();
        }
        
        getBoard().chooseSquare(xPos, yPos);
        isMine(xPos,yPos);
        
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
             nextLevel();
             
             this.setChanged();
            this.notifyObservers();
         }
     }
     
    public void nextLevel(){
        
        //newgame med någon trevlig formel som ökar mines, width o height
    }
    
    @Override
    public void newGame(int mines, int width, int height) {
        if(mines < 0 || width < 0 || height < 0)
            throw new IllegalArgumentException();
        
        this.mines = mines;
        
        this.currentLives = CAMPAIGN_LIVES;
        
        this.width = width;
        this.height = height;
        
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
