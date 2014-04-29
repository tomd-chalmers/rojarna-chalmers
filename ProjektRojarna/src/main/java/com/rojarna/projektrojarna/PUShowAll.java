/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tom
 */
public class PUShowAll implements PowerupInterface{
    private final int COST=100;
    private List<Boolean> listOfShown = new ArrayList<Boolean>();
    public void power(GameBoard gb, int x, int y) {
        for(int i = 0; i<gb.getHeight();i++){
            for(int j = 0; j<gb.getWidth();j++){
                listOfShown.add(gb.getSquare(i,j).isVisible());
                if(!gb.getSquare(i,j).isVisible()){
                    gb.getSquare(i, j).setVisible(true);
                }
            }
        }
        //wait a few sec here...
        int k = 0;
        for(int i = 0;i<gb.getHeight();i++){
            for(int j = 0; j<gb.getWidth();j++){
                if(!listOfShown.get(k)){
                    gb.getSquare(i,j).setVisible(false);
                }
                k++;
            }
        }
    }

    public int getCost() {
        return COST;
    }
    
}
