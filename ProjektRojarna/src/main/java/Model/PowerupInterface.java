/**
 * The inteface for all powerups.
 * @author Tom
 */

package Model;

import Model.GameBoard;


public interface PowerupInterface{
    public void power(GameBoard gb, int x, int y);
    public int getCost();
}
