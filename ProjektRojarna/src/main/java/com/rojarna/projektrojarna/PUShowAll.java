/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Tom
 */
public class PUShowAll implements PowerupInterface{
    private final int COST=100;
    public void power(GameBoard gb, int x, int y) {
        for(int i = 0; i<gb.getHeight();i++){
            for(int j = 0; j<gb.getWidth();j++){
                if(gb.getSquare(i,j).isVisible()){
                    
                }
                    //svårt... 
            }
        }
    }

    public int getCost() {
        return COST;
    }
    
}
