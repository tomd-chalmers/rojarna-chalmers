/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;
import com.rojarna.projektrojarna.Square.Marking;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Tom
 */
public class GameBoardTest extends TestCase {
    
    public GameBoardTest(String testName) {
        super(testName);
        //hur testar man en konstruktor
    }

    public void testGetBorder() {
        GameBoard gb = new GameBoard();
        //List<Point> border = new ArrayList<Point>();
        //border = gb.getBorder();
        // INTE KLAR.
    }

    public void testChooseSquare() {
        GameBoard gb = new GameBoard(0,5,5);
        gb.chooseSquare(2, 2);
        assertTrue(gb.getSquare(2, 2).isVisible());
        // mera här.
    }

    public void testMarkSquare() {
        GameBoard gb = new GameBoard(0,5,5);
        gb.markSquare(2, 2);
        assertTrue(gb.getSquareMarking(2, 2) == Marking.FLAG);
        gb.markSquare(2, 2);
        assertTrue(gb.getSquareMarking(2, 2) == Marking.QUESTION);
        gb.markSquare(2, 2);
        assertTrue(gb.getSquareMarking(2, 2) == Marking.NONE);
    }

    public void testIsAllNumberShown() {
        GameBoard gb = new GameBoard(5,3,3);
        gb.chooseSquare(0,0);//nu borde 0,0 vara tom
        // dvs att 01 , 11 och 10 är siffror, kvar blir då 5 minor.
        assertTrue(gb.isAllNumberShown());
    }

    public void testReset() {
        GameBoard gb = new GameBoard();
        gb.chooseSquare(0,0);
        gb.reset();
        assertTrue(!gb.getSquare(0,0).isVisible());
    }

    public void testIsClicked() {
        GameBoard gb = new GameBoard();
        gb.chooseSquare(2,2);
        assertTrue(gb.isClicked());
    }

    public void testShowMines() {
        GameBoard gb = new GameBoard(10,5,5);
        int mineCounter=0;
        int x =0;
        int y =0;
        for(int i = 0; i<25;i++){
            if(gb.getSquare(x,y).isVisible() || gb.getSquareItem(x,y)==Item.MINE){
                mineCounter++;
            }
            if(y<5){
                y++;
            }else{
                y=0;
                x++;
            }
        }
        assertTrue(mineCounter==10);
    }

    public void testShowSquare() {
        GameBoard gb = new GameBoard();
        gb.showSquare(3, 3, true);
        assertTrue(gb.getSquare(3, 3).isVisible());
        gb.showSquare(3, 3, false);
        assertTrue(!gb.getSquare(3, 3).isVisible());
    }

    public void testGetSquareMarking() {
        //testat i markSquare
    }

    public void testGetSquareItem() {
        GameBoard gb = new GameBoard(1,1,1);
        assertTrue(gb.getSquareItem(0,0)==Item.MINE);// vet inte om detta funkar
    }

    public void testGetWidth() {
        GameBoard gb = new GameBoard(2,3,2);
        assertTrue(gb.getHeight()==2);
    }

    public void testGetHeight() {
        GameBoard gb = new GameBoard(2,3,2);
        assertTrue(gb.getWidth()==3);
    }

    public void testGetMines() {
        GameBoard gb = new GameBoard(2,2,2);
        assertTrue(gb.getMines()==2);
    }

    public void testGetSquare() {
        //hur testar man denna???   
    }

    public void testSystemPrint() {
    }

    public void testMain() {
    }
    
}
