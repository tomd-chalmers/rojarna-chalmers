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
import com.rojarna.projektrojarna.Square.Marking;

import java.util.Scanner;



/**
 *
 * @author Tobias
 * @revised Oskar Frost
 * @revised Joakim Milleson
 * @revised Oskar Frost
 */
public class GameBoard {
	
	private Square[][] board;
	private int mines,width,height;
        private boolean firstClick = true;
        
    
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
                this.height = height;
                this.width = width;
	}
	
	private void initBoard(int x,int y){
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
        
        public void chooseSquare(int x, int y){
            if(firstClick){
                initBoard(x,y);
                firstClick = false;
            }
            if(getSquareMarking(x,y) != Marking.FLAG){
                board[y][x].setVisible(true);
                if(getSquareItem(x,y) == Item.MINE){
                    System.out.print("Mina");
                } else if(getSquareItem(x,y) == Item.NUMBER && board[y][x].getValue() == 0){
                    for(Point p:getBorder(x,y)){
                        if(!board[p.y][p.x].isVisible()){
                            chooseSquare(p.x,p.y);
                        }   
                    }
                }
            }
        }
        
        public void markSquare(int x, int y){
            board[y][x].markSquare();
        }
        
        public boolean isAllNumberShown(){
            for(int i = 0; i<height; i++){
		for(int j = 0; j<width; j++){
                    if(getSquareItem(j,i) == Item.NUMBER && !board[i][j].isVisible()){
                        return false;
                    }
                }
            }
            return true;
        }
        
        public void reset(){
            for(int i = 0; i<height; i++){
		for(int j = 0; j<width; j++){
                    board[i][j].setVisible(false);
                    board[i][j].setMarking(Marking.NONE);
                }
            }
        }
        
        public void showSquare(int x, int y, boolean visible){
            board[y][x].setVisible(visible);
        }

        public Marking getSquareMarking(int x, int y){
            return board[y][x].getMarking();
        }
        
        public Item getSquareItem(int x, int y){
            return board[y][x].getItem();
        }
        
        public int getWidth(){
            return width;
        }
        
        public int getHeight(){
            return height;
        }
        
        public int getMines(){
            return mines;
        }
        
        public Square getSquare(int i, int j){
            return board[j][i];
        }
        
	
        public void systemPrint(){
            System.out.println();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j].isVisible()){
                                        if(board[i][j].isMine()){
                                                System.out.print("[*]");
                                        }else{
                                                System.out.print("["+board[i][j].getValue()+"]");
                                        }
                                } else {
                                    System.out.print("[ ]");
                                }
			}
			System.out.println("");
		}
	}
	
	public static void main(String[]args){
		GameBoard g = new GameBoard();
                Scanner sc = new Scanner(System.in);
                int x,y;
                x = sc.nextInt();
                y = sc.nextInt();
                g.initBoard(x, y);
                g.chooseSquare(x, y);
                g.systemPrint();
                
                while(true){
                    g.chooseSquare(sc.nextInt(),sc.nextInt());
                    g.systemPrint();
                    if(g.isAllNumberShown()){
                        System.out.println("Victory");
                    }
                    
                }
	}
}
