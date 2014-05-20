/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.rojarna.projektrojarna.Square.Item;
import static com.rojarna.projektrojarna.Square.Item.*;
import com.rojarna.projektrojarna.Square.Marking;

/**
 *
 * @author Tom
 */
public class PUChooseRandomFour implements PowerupInterface{
    private final int COST=5;
    private int x, y, invisible;
    private final PropertyChangeSupport prop = new PropertyChangeSupport(this);


    public void power(GameBoard gb, int x, int y) {
        invisible = 0;
        for(int i = 0; i < gb.getHeight(); i++){
            for(int j = 0; j < gb.getWidth(); j++){
                if(!gb.getSquare(i, j).isVisible()){
                    if(!(gb.getSquareItem(i, j) == Item.MINE && gb.getSquareMarking(i, j) == Marking.FLAG)){
                        invisible++;
                    }
                }
            }
        }
        
        if(invisible > 4){
            invisible = 4;
        }
        for(int i = 0; i < invisible; i++){
            do{
                x = (int)(Math.random() * gb.getWidth());
                y = (int)(Math.random() * gb.getHeight());
            } while(gb.getSquare(x, y).isVisible() || gb.getSquareItem(x, y) == 
                    Item.MINE && gb.getSquareMarking(x, y) == Marking.FLAG);
            
            if(gb.getSquareItem(x, y) == Item.MINE){
                while(gb.getSquareMarking(x, y) != Marking.FLAG){
                    gb.markSquare(x, y);
                }
            } else {
                if(gb.getSquareMarking(x, y) == Marking.FLAG){
                    gb.markSquare(x, y);
                }
                gb.chooseSquare(x, y);
            }
        }
    }

    public int getCost() {
        return COST;
    }
}
