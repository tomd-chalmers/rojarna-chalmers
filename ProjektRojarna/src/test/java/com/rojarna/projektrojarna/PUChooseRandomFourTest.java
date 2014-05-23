/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;

/**
 *
 * @author Joakim
 */
public class PUChooseRandomFourTest extends TestCase {
    
    public PUChooseRandomFourTest(String testName) {
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
        PUChooseRandomFour pu = new PUChooseRandomFour();
        GameBoard gb = new GameBoard();
        int invisible = pu.getInvisible(gb);
        pu.power(gb, 0, 0);
        assertTrue(invisible > pu.getInvisible(gb));
    }

    public void testGetInvisible() {
        PUChooseRandomFour pu = new PUChooseRandomFour();
        GameBoard gb = new GameBoard();
        assertTrue(pu.getInvisible(gb) == 64);
        for(int i = 0; i < 8; i++){
            gb.getSquare(i, i).setVisible(true);
        }
        assertTrue(pu.getInvisible(gb) == 56);
        
        for(int i = 0; i < 8; i++){
            gb.getSquare(i, i).setVisible(false);
            gb.getSquare(i, i).setItem(Square.Item.MINE);
            gb.getSquare(i, i).setMarking(Square.Marking.FLAG);
        }
        assertTrue(pu.getInvisible(gb) == 56);
    }

    public void testGetCost() {
        PUChooseRandomFour pu = new PUChooseRandomFour();
        assertTrue(pu.getCost() == 15);
    }
    
}
