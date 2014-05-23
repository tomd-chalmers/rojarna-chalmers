/*
 * A powerup that is available in the CampaignModel.
 * After the person first use this powerup, he/she also has to choose a square.
 * the powerup will choose the square and if it is a mine it will "flagg" the
 * square. It will also make the same with all the square that is next to the
 * choosen square.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Tom
 */
public class PUChooseSafeArea implements PowerupInterface{
    
    private final int COST=30;
    
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
