/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Tom
 */
public class PUShowAll implements PowerupInterface{
    private final int COST=10;
    private final PropertyChangeSupport prop = new PropertyChangeSupport(this);

    //private List<Boolean> listOfShown = new ArrayList<Boolean>();
    public void power(GameBoard gb, int x, int y) {
        gb.showMines(true);
        prop.firePropertyChange("PU",true,false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("error: in PUShowAll, thread interupted");
        }
        gb.showMines(false);
        prop.firePropertyChange("PU",true,false);
    }

    public int getCost() {
        return COST;
    }
         public void addPropertyChangeListener(PropertyChangeListener l) {
         prop.addPropertyChangeListener(l);
     }

     public void removePropertyChangeListener(PropertyChangeListener l) {
         prop.removePropertyChangeListener(l);
     }
    
}
