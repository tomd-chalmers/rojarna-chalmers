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
    
    public CampaignModel(){
        
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        gameBoard.chooseSquare(xPos, yPos);
        
    }
    
     public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        gameBoard.markSquare(xPos, yPos);
        
    }
    
    @Override
    public void newGame(int mines, int width, int heigth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
