/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;
import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;

/**
 *
 * @author Joakim
 */
public class SquareTest extends TestCase {
    
    public SquareTest(String testName) {
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

    public void testGetItem() {
        Square s = new Square();
        assertTrue(s.getItem() == Item.NUMBER);
        s.setItem(Item.MINE);
        assertTrue(s.getItem() == Item.MINE);
    }

    public void testSetItem() {
        Square s = new Square();
        assertTrue(s.getItem() == Item.NUMBER);
        s.setItem(Item.MINE);
        assertTrue(s.getItem() == Item.MINE);
    }

    public void testIncValue() {
        Square s = new Square();
        assertTrue(s.getValue() == 0);
        s.incValue();
        assertTrue(s.getValue() == 1);
    }

    public void testDecValue() {
    }

    public void testGetValue() {
    }

    public void testIsMine() {
    }

    public void testIsVisible() {
    }

    public void testSetVisible() {
    }

    public void testSetMarking() {
    }

    public void testMarkSquare() {
    }

    public void testGetMarking() {
    }
    
}
