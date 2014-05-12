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
        //normal case:
        /*int newX=x--;
        int newY=y--;*/
        /*if(x>0 && y>0 && x<gb.getHeight() && y<gb.getWidth()){
            for(int newX = x-1 ;newX<x+1;newX++){
                for(int newY = y-1; newY<y+1;newY++){
                    if(gb.getSquareItem(newX, newY)== MINE){
                        gb.getSquare(newX, newY).setMarking(Square.Marking.FLAG);
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
                            gb.getSquare(newX, newY).setMarking(Square.Marking.FLAG);
                        }
                    }
                }
            }
        }*/
        List <Point> tmp = gb.getBorder(x,y);
        tmp.add(new Point(x,y));
        for(Point p:tmp){
            if(gb.getSquareItem(p.x, p.y)==Item.MINE){
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
