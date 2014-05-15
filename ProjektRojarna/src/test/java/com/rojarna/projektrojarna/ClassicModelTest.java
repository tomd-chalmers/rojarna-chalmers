/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;
import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;
import com.rojarna.projektrojarna.ClassicModel.GameState;

/**
 *
 * @author Joakim
 */
public class ClassicModelTest extends TestCase {
    
    public ClassicModelTest(String testName) {
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

    public void testNewGame() {
        ClassicModel m = new ClassicModel();
        
    }

    public void testChooseSquare() {
        ClassicModel m = new ClassicModel();
        assertTrue(m.getGameTimer() == null);
        m.chooseSquare(2, 2);
        assertTrue(m.getGameTimer() != null);
        assertTrue(m.getBoard().getSquare(2, 2).isVisible());
        //Testa mer?
    }

    public void testMarkSquare() {
        ClassicModel m = new ClassicModel();
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.NONE);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.FLAG);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.QUESTION);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.NONE);
    }

    public void testGameOver() {
        ClassicModel m = new ClassicModel();
    }

    public void testRestartGame() {
        ClassicModel m = new ClassicModel();
        m.chooseSquare(7, 0);
        for(int i = 0; i < 6; i++){
            m.markSquare(i+1, i+1);
            m.getBoard().getSquare(i, i).setVisible(true);
        }
        for(int i = 0; i < 6; i++){
            assertTrue(m.getBoard().getSquare(i, i).isVisible());
            assertTrue(m.getBoard().getSquare(i+1, i+1).getMarking() == Marking.FLAG);
        }
        m.restartGame();
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                assertFalse(m.getBoard().getSquare(i, j).isVisible());
                assertTrue(m.getBoard().getSquare(i, j).getMarking() == Marking.NONE);
            }
        }
        
    }

    public void testPauseGame() {
        ClassicModel m = new ClassicModel();
    }

    public void testGetSquare() {
        ClassicModel m = new ClassicModel();
        Square s = m.getBoard().getSquare(2,2);
        m.getBoard().getSquare(2,2).setItem(Item.MINE);
        m.getBoard().getSquare(2,2).setMarking(Marking.FLAG);
        m.getBoard().getSquare(2,2).setVisible(true);
        s.setItem(Item.MINE);
        s.setMarking(Marking.FLAG);
        s.setVisible(true);
        assertTrue(m.getBoard().getSquare(2,2).equals(s));
        
    }

    public void testSetGameState() {
        ClassicModel m = new ClassicModel();
        m.setGameState(GameState.PLAYING);
        assertTrue(m.getGameState() == GameState.PLAYING);
    }

    public void testGetGameState() {
        ClassicModel m = new ClassicModel();
        m.setGameState(GameState.PLAYING);
        assertTrue(m.getGameState() == GameState.PLAYING);
    }
    
}
