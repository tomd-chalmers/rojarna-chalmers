/*
 * The inteface for all powerups.
 */

package Model;

import Model.GameBoard;


/**
 *
 * @author Tom
 */
public interface PowerupInterface{
    public void power(GameBoard gb, int x, int y);
    public int getCost();
}
