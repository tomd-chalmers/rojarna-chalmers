/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;
import static com.rojarna.projektrojarna.Square.Item.*;
import com.rojarna.projektrojarna.Square.Marking;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joakim
 */
public class PUChooseSafeSingle implements PowerupInterface{

    private final int COST = 10;
    
    public void power(GameBoard gb, int x, int y) {
        if(gb.getSquare(x,y).getItem()==Item.MINE){
            gb.getSquare(x,y).setMarking(Marking.FLAG);
        } else {
            gb.getSquare(x,y).setMarking(Marking.NONE);
            gb.chooseSquare(x,y);
        }
    }

    public int getCost() {
        return COST;
    }
    
}
