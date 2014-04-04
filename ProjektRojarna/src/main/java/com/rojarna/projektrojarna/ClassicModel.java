/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Tobias
 */
public class ClassicModel extends AbstractGameModel{
    
    private GameBoard gameBoard;
    
    private boolean boardClicked = false;
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!boardClicked){
            gameBoard.initBoard(xPos, yPos);
            boardClicked = true;
        }
        gameBoard.chooseSquare(xPos, yPos);
        
        if(gameBoard.getSquareItem(xPos, yPos) == Square.Item.MINE){
            GameOver();
        }
    }
    
    private void GameOver(){
        ;
    }

    @Override
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        gameBoard = new GameBoard(mines, width, heigth);
        boardClicked = false;
    }
    
}
