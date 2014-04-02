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
        
        public void markSquare(int x, int y){
                board[y][x].markSquare();
        }
        
        public void chooseSquare(int x, int y){
            if(board[y][x].getItem() == Item.MINE){
                    board[y][x].setVisible(true);
                    System.out.println("Mina");
            } else if(board[y][x].getItem() == Item.NUMBER && board[y][x].getValue() == 0){
                    board[y][x].setVisible(true);
                    for(int i = -1; i < 2; i++){
                        for(int j = -1; j < 2; j++){
                            if(x+j < width && x+j >= 0 && y+i < height && y+i >= 0){
                                if(!board[y+i][x+j].isVisible()){
                                    chooseSquare(x + j,y + i);
                                }
                            }
                        }
                    }
            } else {
                    board[y][x].setVisible(true);
            }
        }
        
        public Item getSquareItem(int x, int y){
            return board[y][x].getItem();
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
                                } else if(board[i][j].getMarking() == Marking.FLAG) {
                                    System.out.print("[F]");
                                } else if(board[i][j].getMarking() == Marking.QUESTION){
                                    System.out.print("[?]");
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
                    
                }
	}
}
