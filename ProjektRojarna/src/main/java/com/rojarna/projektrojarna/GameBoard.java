/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.List;

/**
 *
 * @author Gaming
 */
public class GameBoard {
    
    private int mineCount;
    private int width;
    private int height;
    
    private boolean hasInit;
    
    private List[][] squares;
    
    public GameBoard(){
        width = 7;
        height = 7;
        mineCount = 10;
    }
    
    public GameBoard(int mineCount, int width, int height){
        this.width = width;
        this.height = height;
        this.mineCount = mineCount;
    }
    
    public void chooseSquare(int x, int y){
        
    }
    
    public void markSquare(int x, int y){
        squares[x][y].markSquare();
    }
    
    public State getState(int x, int y){
        return squares[x][y].getState();
    }
}
