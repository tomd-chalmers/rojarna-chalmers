/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import static com.rojarna.projektrojarna.Square.Item.*;

/**
 *
 * @author Tom
 */
public class PUSafeChooseArea implements PowerupInterface{
    
    private final int COST=100;
    
    public void power(GameBoard gb, int x, int y) {
        Square s = new Square();
        //normal case:
        /*int newX=x--;
        int newY=y--;*/
        if(x>0 && y>0 && x<gb.getHeight() && y<gb.getWidth()){
            for(int newX = x-1 ;newX<x+1;newX++){
                for(int newY = y-1; newY<y+1;newY++){
                    if(gb.getSquareItem(newX, newY)== MINE){
                        gb.getSquare(newX, newY).markSquare();
                        // buggar om det är ett frågetäcken.
                    }else{
                        gb.chooseSquare(newX, newY);
                    }
                }
            }
        }// end normal case
        else{
            int newX=x-1;
            int newY=y-1;
            for(int i = 0; i<2; i++){
                for(int j =0; j<2; j++){
                    int newnewX=newX+i;
                    int newnewY=newY+j;
                    if(newnewX<0 || newnewX>gb.getHeight()){
                        // do nothing
                    }else if(newnewY<0 || newnewY>gb.getWidth()){
                        // do nothing
                    }else{
                        if(gb.getSquareItem(newnewX, newnewY)== MINE){
                            
                        }
                    }
                }
            }
        }
    }

    public int getCost() {
        return COST;
    }
    
}
