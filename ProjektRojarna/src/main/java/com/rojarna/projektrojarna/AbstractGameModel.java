/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.Observable;

/**
 *
 * @author Tobias
 */
public abstract class AbstractGameModel extends Observable{
    
    
    public abstract void newGame(int mines, int width, int heigth);
}
