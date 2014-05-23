/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;
import com.rojarna.projektrojarna.Square.Item;
import static com.rojarna.projektrojarna.Square.Item.*;
import com.rojarna.projektrojarna.Square.Marking;

/**
 *
 * @author Joakim
 */
public class PUChooseSafeSingleTest extends TestCase {
    
    public PUChooseSafeSingleTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPower() {
        PUChooseSafeSingle p = new PUChooseSafeSingle();
        //try power on a square with Item == Mine
        GameBoard gb = new GameBoard();
        gb.chooseSquare(7,7);
        gb.getSquare(0, 0).setItem(Item.MINE);
        gb.getSquare(0, 0).setVisible(false);
        p.power(gb, 0, 0);
        assertTrue(gb.getSquare(0, 0).getMarking() == Marking.FLAG);
        assertFalse(gb.getSquare(0, 0).isVisible());
        //try power on a square with Item == Number and Marking = Flag
        gb = new GameBoard();
        gb.chooseSquare(7,7);
        gb.getSquare(0, 0).setItem(Item.NUMBER);
        gb.getSquare(0, 0).setMarking(Marking.FLAG);
        gb.getSquare(0, 0).setVisible(false);
        p.power(gb, 0, 0);
        assertTrue(gb.getSquare(0, 0).getMarking() != Marking.FLAG);
        assertTrue(gb.getSquare(0, 0).isVisible());
        //try power on a square with Item == Number and Marking = None
        gb = new GameBoard();
        gb.chooseSquare(7,7);
        gb.getSquare(0, 0).setItem(Item.NUMBER);
        gb.getSquare(0, 0).setMarking(Marking.NONE);
        gb.getSquare(0, 0).setVisible(false);
        p.power(gb, 0, 0);
        assertTrue(gb.getSquare(0, 0).getMarking() == Marking.NONE);
        assertTrue(gb.getSquare(0, 0).isVisible());
        
    }

    public void testGetCost() {
        PUChooseSafeSingle p = new PUChooseSafeSingle();
        assertTrue(p.getCost() == 5);
    }
    
}
