/*
 * A powerup that is available in the CampaignModel.
 * It choose four squares, at random, and in case one of theese would be an
 * mine it sets the marking to FLAGGED.
 */

package Model;

import Model.GameBoard;
import java.beans.PropertyChangeSupport;
import Model.Square.Item;
import Model.Square.Marking;

/**
 *
 * @author Tom
 */
public class PUChooseRandomFour implements PowerupInterface{
    private final int COST=15;
    private int x, y, invisible;
    private final PropertyChangeSupport prop = new PropertyChangeSupport(this);


    public void power(GameBoard gb, int x, int y) {
        invisible = getInvisible(gb);
        
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
    
    public int getInvisible(GameBoard gb){
        int a = 0;
        for(int i = 0; i < gb.getWidth(); i++){
            for(int j = 0; j < gb.getHeight(); j++){
                if(!gb.getSquare(i, j).isVisible()){
                    if(!(gb.getSquareItem(i, j) == Item.MINE && gb.getSquareMarking(i, j) == Marking.FLAG)){
                        a++;
                    }
                }
            }
        }
        return a;
    }

    public int getCost() {
        return COST;
    }
}
