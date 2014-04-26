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

    private GameBoard gameBoard = null;
    
    private int mines, width, height, life = 3;
    
    public CampaignModel(){
        newGame(10,8,8);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        gameBoard.chooseSquare(xPos, yPos);
        isMine(xPos,yPos);
        
    }
    
    public void isMine(int x, int y){
        if(getSquare(x,y).getItem() == Item.MINE){
            if(life > 0){
                life -= 1;
            } else {
                gameOver();
            }
        }
    }
    
     public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        gameBoard.markSquare(xPos, yPos);
        
    }
     
    public void nextLevel(){
        //newgame med någon trevlig formel som ökar mines, width o height
    }
    
    @Override
    public void newGame(int mines, int width, int height) {
        if(mines < 0 || width < 0 || height < 0)
            throw new IllegalArgumentException();
        
        this.mines = mines;
        this.width = width;
        this.height = height;
        
        setBoard(new GameBoard(mines, width, height));
        
        //vet inte riktigt hur vi ska göra här
        this.notifyObservers();
        //this.notifyObservers(gameBoard);
        //this.notifyObservers(gameBoard.copy());
    }

    @Override
    public void gameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Square getSquare(int x, int y) {
        return getBoard().getSquare(x, y);
    }
    
}
