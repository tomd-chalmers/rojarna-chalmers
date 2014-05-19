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
public class PUChooseSafeAreaTest extends TestCase {
    
    public PUChooseSafeAreaTest(String testName) {
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
        GameBoard gb = new GameBoard();
        PUChooseSafeArea p = new PUChooseSafeArea();
        for(int i = 0; i < 8; i++){
            gb.getSquare(i, i).setItem(Square.Item.MINE);
            gb.getSquare(i, i).setVisible(false);
        }
        
        p.power(gb, 1, 1);
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(i == j){
                    assertTrue(gb.getSquareMarking(i, i) == Marking.FLAG);
                    assertFalse(gb.isVisible(i, i));
                } else {
                    assertTrue(gb.getSquareMarking(i, j) != Marking.FLAG);
                    assertTrue(gb.isVisible(i, j));
                }
            }
        }
    }

    public void testGetCost() {
        PUChooseSafeArea p = new PUChooseSafeArea();
        assertTrue(p.getCost() == 10);
    }
    
}
