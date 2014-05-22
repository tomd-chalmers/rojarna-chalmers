/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;
import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;
import com.rojarna.projektrojarna.CampaignModel.State;

/**
 *
 * @author Joakim
 */
public class CampaignModelTest extends TestCase {
    
    public CampaignModelTest(String testName) {
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

    public void testChooseSquare() {
        CampaignModel m = new CampaignModel();
        m.getBoard().getSquare(2, 2).setMarking(Marking.FLAG);
        m.chooseSquare(2,2);
        assertFalse(m.getBoard().getSquare(2, 2).isVisible());
        m.getBoard().getSquare(2, 2).setMarking(Marking.NONE);
        m.chooseSquare(2, 2);
        assertTrue(m.getBoard().getSquare(2, 2).isVisible());
        
    }

    public void testIsMine() {
        CampaignModel m = new CampaignModel();
        m.getBoard().getSquare(2, 2).setItem(Item.MINE);
        assertTrue(m.isMine(2, 2));
        m.getBoard().getSquare(2, 2).setItem(Item.NUMBER);
        assertFalse(m.isMine(2, 2));
    }

    public void testMarkSquare() {
        CampaignModel m = new CampaignModel();
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.NONE);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.FLAG);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.QUESTION);
        m.getBoard().markSquare(2, 2);
        assertTrue(m.getBoard().getSquareMarking(2, 2) == Marking.NONE);
    }

    public void testUsePowerup() {
        CampaignModel m = new CampaignModel();
        PUChooseSafeSingle pu1 = new PUChooseSafeSingle();
        PUChooseSafeArea pu2 = new PUChooseSafeArea();
        int time = m.getGameTime();
        m.usePowerup(pu1, 2, 2);
        
        assertTrue(m.getGameTime() == (time - pu1.getCost()));
        assertTrue(m.getBoard().getSquare(2, 2).isVisible());
        
        time = m.getGameTime();
        m.usePowerup(pu2, 5, 5);
        
        assertTrue(m.getGameTime() == (time - pu2.getCost()));
        for(int i = 4; i < 7; i++){
            for(int j = 4; j < 7; j++){
                if(m.getBoard().getSquareItem(i,j) == Item.NUMBER){
                    assertTrue(m.getBoard().getSquare(i, j).isVisible());
                } else{
                    assertFalse(m.getBoard().getSquare(i, j).isVisible());
                }
            }
        }
    }

    public void testIsLvlComplete() {
        CampaignModel m = new CampaignModel();
        assertFalse(m.isLvlComplete());
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                m.getBoard().getSquare(i, j).setVisible(true);
                m.getBoard().getSquare(2, 2).setItem(Item.NUMBER);
            }
        }
        assertTrue(m.isLvlComplete());
        m.getBoard().getSquare(2, 2).setVisible(false);
        m.getBoard().getSquare(2, 2).setItem(Item.MINE);
        assertTrue(m.isLvlComplete());
        m.getBoard().getSquare(3, 3).setVisible(false);
        assertFalse(m.isLvlComplete());
    }

    public void testGetSquare() {
        CampaignModel m = new CampaignModel();
        Square s = m.getBoard().getSquare(2,2);
        m.getBoard().getSquare(2,2).setItem(Item.MINE);
        m.getBoard().getSquare(2,2).setMarking(Marking.FLAG);
        m.getBoard().getSquare(2,2).setVisible(true);
        s.setItem(Item.MINE);
        s.setMarking(Marking.FLAG);
        s.setVisible(true);
        assertTrue(m.getBoard().getSquare(2,2).equals(s));
    }

    public void testGetLevel() {
        CampaignModel m = new CampaignModel();
        assertTrue(m.getLevel() == 1);
    }

    public void testGetLives() {
        CampaignModel m = new CampaignModel();
        assertTrue(m.getLives() == 3);
    }

    public void testIsGameOver() {
        CampaignModel m = new CampaignModel();
        assertFalse(m.isGameOver());
    }

    public void testGetState() {
        CampaignModel m = new CampaignModel();
        assertTrue(m.getState() == State.PLAYING);
    }

    public void testPauseGame() {
        CampaignModel m = new CampaignModel();
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
        
        assertTrue(m.getGameTime() < time);
    }
    
    public void sleep() throws Exception{
        Thread.sleep(2000);
    }

    public void testGetMines() {
        CampaignModel m = new CampaignModel();
        assertTrue(m.getMines() == 10);
    }

}
