/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Tom
 */
public interface PowerupInterface {
    public void power(GameBoard gb, int x, int y);
    public int getCost();
}
