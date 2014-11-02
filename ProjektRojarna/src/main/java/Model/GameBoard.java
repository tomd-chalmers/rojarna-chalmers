 /*
 * Creates a game board in diffrent sizes, with X amount of mines.
 * also contains method like reset and other method to make the gameboard
 * versatile and easy to use if the need to create another gameModel emerge.
 *
 * GameBoard are using multiple instances of Square to form the board. 
 */

package Model;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import Model.Square.Item;
import Model.Square.Marking;




/**
 *
 * @author Tobias
 * @revised Oskar Frost
 * @revised Joakim Milleson
 * @revised Oskar Frost
 */
public class GameBoard{
	
    private Square[][] board;
    private int mines,width,height;
    private boolean boardClicked, boardReset = false, boardInit = false;
    private int flagCounter = 0;

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
        boardInit = true;
        List<Point> tmp = getBorder(x,y);
        for(int i=0; i<mines; i++){
            int randX;
            int randY;
            Point p;
            
            do{
                randX = (int) (board[0].length*Math.random());
                randY = (int) (board.length*Math.random());
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
    
    public List<Point> getBorder(int x,int y){
        ArrayList<Point> tmp = new ArrayList<Point>();
        if(x>0){
            tmp.add(new Point(x-1,y));
            
            if(y>0){
                tmp.add(new Point(x-1,y-1));
            }if (y<board.length-1){
                tmp.add(new Point(x-1,y+1));
            }
        }
        if(x<board[y].length-1){
            tmp.add(new Point(x+1,y));
            
            if(y>0){
                tmp.add(new Point(x+1,y-1));
            }if(y<board.length-1){
                tmp.add(new Point(x+1,y+1));
            }
        }
        if(y>0){
            tmp.add(new Point(x,y-1));
        }
        if(y<board.length-1){
            tmp.add(new Point(x,y+1));
        }
        
        return tmp;
    }

    public Item chooseSquare(int x, int y){
        if(!boardClicked){
            if(!boardReset || !boardInit){
                initBoard(x,y);
            } else{
                boardReset = false;
            }
            
            boardClicked = true;
        }

        if(getSquareMarking(x,y) != Marking.FLAG){
            board[y][x].setVisible(true);
            
            if(getSquareItem(x,y) == Item.NUMBER && board[y][x].getValue() == 0){

                for(Point p:getBorder(x,y)){
                    if(!board[p.y][p.x].isVisible()){
                        chooseSquare(p.x,p.y);
                    }   
                }
            }
        }

        return board[y][x].getItem();
    }

    public void markSquare(int x, int y){
        board[y][x].markSquare();
        if(board[y][x].getMarking().equals(Marking.FLAG)){
            flagCounter++;
        }else if(board[y][x].getMarking().equals(Marking.QUESTION)){
            flagCounter--;
        }
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
        boardClicked = false;
        boardReset = true;
        
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                board[i][j].setVisible(false);
                board[i][j].setMarking(Marking.NONE);
            }
        }
    }

    public boolean isClicked(){
        return boardClicked;
    }

    public void showMines(boolean show){
        for(int i = 0; i < width; i++){
            
            for(int j = 0; j < height; j++){
                
                if(board[j][i].isMine()){
                    showSquare(i,j,show);
                }
            }
        }
    }

    public void showSquare(int x, int y, boolean visible){
        board[y][x].setVisible(visible);
    }
    public boolean isVisible(int x,int y){
        return board[y][x].isVisible();
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
    public int getFlags(){
        return flagCounter;
    }
}
