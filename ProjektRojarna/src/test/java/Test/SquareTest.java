/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.Square;
import junit.framework.TestCase;
import Model.Square.Item;
import Model.Square.Marking;

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
        Square s = new Square();
        assertTrue(s.getValue() == 0);
        s.incValue();
        s.incValue();
        s.decValue();
        assertTrue(s.getValue() == 1);
    }

    public void testGetValue() {
        Square s = new Square();
        assertTrue(s.getValue() == 0);
        s.incValue();
        assertTrue(s.getValue() == 1);
    }

    public void testIsMine() {
        Square s = new Square();
        assertFalse(s.isMine());
        s.setItem(Item.MINE);
        assertTrue(s.isMine());
    }

    public void testIsVisible() {
        Square s = new Square();
        assertFalse(s.isVisible());
        s.setVisible(true);
        assertTrue(s.isVisible());
    }

    public void testSetVisible() {
        Square s = new Square();
        assertFalse(s.isVisible());
        s.setVisible(true);
        assertTrue(s.isVisible());
    }

    public void testSetMarking() {
        Square s = new Square();
        assertTrue(s.getMarking() == Marking.NONE);
        s.setMarking(Marking.FLAG);
        assertTrue(s.getMarking() == Marking.FLAG);
    }

    public void testMarkSquare() {
        Square s = new Square();
        assertTrue(s.getMarking() == Marking.NONE);
        s.markSquare();
        assertTrue(s.getMarking() == Marking.FLAG);
        s.markSquare();
        assertTrue(s.getMarking() == Marking.QUESTION);
        s.markSquare();
        assertTrue(s.getMarking() == Marking.NONE);
    }

    public void testGetMarking() {
        Square s = new Square();
        assertTrue(s.getMarking() == Marking.NONE);
        s.setMarking(Marking.FLAG);
        assertTrue(s.getMarking() == Marking.FLAG);
    }
    
}
