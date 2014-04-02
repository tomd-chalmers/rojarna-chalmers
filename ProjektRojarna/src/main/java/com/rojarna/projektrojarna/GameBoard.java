/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import com.rojarna.projektrojarna.Square.Item;

/**
 *
 * @author Gaming
 * @revised Oskar Frost
 */
public class GameBoard {
	
	private Square[][] board;
	private int mines;
    
	public GameBoard(){
		this(10,8,8);
	}
	public GameBoard(int mines, int height, int width){
		board= new Square[height][width];
		for(int i = 0; i<height; i++){
			for(int j = 0; j<width; j++){
				board[i][j]=new Square();
			}
		}
		this.mines = mines;
	}
	
	public void initBoard(int x,int y){
		List<Point> tmp = getBorder(x,y);
		for(int i=0; i<mines; i++){
			int randX;
			int randY;
			Point p;
			do{
				randX = (int) (board.length*Math.random());
				randY = (int) (board[0].length*Math.random());
				p = new Point(randX,randY);
			}while(board[randY][randX].isMine()||(x==randX&&y==randY)||tmp.contains(p));
			placeMine(randX,randY);
		}
	}
	
	private void placeMine(int x, int y){
		board[y][x].setItem(Item.MINE);
		for(Point p:getBorder(x,y)){
			board[p.y][p.x].incValue();
		}
	}

	private List<Point> getBorder(int x,int y){
		ArrayList<Point> tmp = new ArrayList<Point>();
		if(x>0){
			tmp.add(new Point(x-1,y));
			if(y>0){
				tmp.add(new Point(x-1,y-1));
			}if(y<board[y].length-1){
				tmp.add(new Point(x-1,y+1));
			}
		}
		if(x<board[y].length-1){
			tmp.add(new Point(x+1,y));
			if(y>0){
				tmp.add(new Point(x+1,y-1));
			}if(y<board[y].length-1){
				tmp.add(new Point(x+1,y+1));
			}
		}
		if(y>0){
			tmp.add(new Point(x,y-1));
		}
		if(y<board[y].length-1){
			tmp.add(new Point(x,y+1));
		}
		return tmp;
	}
	
	public void systemPrint(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j].isMine()){
					System.out.print("[*]");
				}else{
					System.out.print("["+board[i][j].getValue()+"]");
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[]args){
		GameBoard g = new GameBoard();
		g.initBoard(3,3);
		g.systemPrint();
	}
}
