/*
 * A powerup that is available in the CampaignModel.
 * After the person first use this powerup, he/she also has to choose a square.
 * the powerup will choose the square and if it is a mine it will "flagg" the
 * square.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;

/**
 *
 * @author Joakim
 */
public class PUChooseSafeSingle implements PowerupInterface{

    private final int COST = 5;
    
    public void power(GameBoard gb, int x, int y) {
        if(gb.getSquare(x, y).getItem()==Item.MINE){
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

    public int getCost() {
        return COST;
    }
    
}
