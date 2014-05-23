/*
 * The inteface for all powerups.
 */

package com.rojarna.projektrojarna;


/**
 *
 * @author Tom
 */
public interface PowerupInterface{
    public void power(GameBoard gb, int x, int y);
    public int getCost();
}
