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
 * @author Tom
 */
public class PUChooseSafeArea implements PowerupInterface{
    
    private final int COST=10;
    
    public void power(GameBoard gb, int x, int y) {
        List <Point> tmp = gb.getBorder(x,y);
        tmp.add(new Point(x,y));
        for(Point p:tmp){
            if(gb.getSquareItem(p.x, p.y)==Item.MINE&&!gb.isVisible(p.x,p.y)){
                while(!gb.getSquareMarking(p.x, p.y).equals(Marking.FLAG)){
                    gb.markSquare(p.x,p.y);
                }
            }else{
                if(gb.getSquareMarking(p.x,p.y).equals(Marking.FLAG))
                    gb.markSquare(p.x, p.y);
                gb.chooseSquare(p.x,p.y);
            }
        }
    }

    public int getCost() {
        return COST;
    }
    
}
