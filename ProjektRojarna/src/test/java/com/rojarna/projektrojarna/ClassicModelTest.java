/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import Model.GameTimer;
import Model.Square;
import Model.ClassicModel;
import junit.framework.TestCase;
import Model.Square.Item;
import Model.Square.Marking;
import Model.ClassicModel.GameState;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void testGetWidth(){
        ClassicModel m = new ClassicModel();
        assertTrue(m.getWidth() == 8);
    }
    
    public void testGetHeight(){
        ClassicModel m = new ClassicModel();
        assertTrue(m.getWidth() == 8);
    }
    
    public void testGetMines(){
        ClassicModel m = new ClassicModel();
        assertTrue(m.getMines() == 10);
    }
    
    public void testIsGamePaused(){
        ClassicModel m = new ClassicModel();
        m.pauseGame(true);
        assertTrue(m.isGamePaused());
    }
    
    public void testGetGameTimeString(){
        ClassicModel m = new ClassicModel();
        m.setGameTimer(new GameTimer(121));
        assertTrue(m.getGameTimeString().equals("02:01"));
    }
    
    public void testGetFlags(){
        ClassicModel m = new ClassicModel();
        for(int i = 0; i < 8; i++){
            m.markSquare(i, i);
        }
        assertTrue(m.getFlags() == 8);
    }

    public void testNewGame() {
        ClassicModel m = new ClassicModel();
        m.newGame(15, 10, 10);
        assertTrue(m.getGameState() == ClassicModel.GameState.PLAYING);
        assertTrue(m.getBoard().getMines() == 15);
        assertTrue(m.getBoard().getHeight() == 10);
        assertTrue(m.getBoard().getWidth() == 10);
        
    }

    public void testChooseSquare() {
        ClassicModel m = new ClassicModel();
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
        m.chooseSquare(2, 2);
        int time = m.getGameTime();
        m.gameOver(true);
        
        try {
            sleep();
        } catch (Exception ex){}
        
        assertTrue(time == m.getGameTime());
    }

    public void testRestartGame() {
        ClassicModel m = new ClassicModel();
        m.setGameTimer(new GameTimer());
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
        m.chooseSquare(2, 2);
        m.pauseGame(true);
        int time = m.getGameTime();
        try {
            sleep();
        } catch (Exception ex){}
        
        assertTrue(m.getGameTime() == time);
        
        m.pauseGame(false);
        
        try {
            sleep();
        } catch (Exception ex){}
        
        assertTrue(m.getGameTime() > time);
        
        
    }
    
    public void sleep() throws Exception{
        Thread.sleep(2000);
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

    public void testGetGameState() {
        ClassicModel m = new ClassicModel();
        assertTrue(m.getGameState() == GameState.PLAYING);
    }
    
}
