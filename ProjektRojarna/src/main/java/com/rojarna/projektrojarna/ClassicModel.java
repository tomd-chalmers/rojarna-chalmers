/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.Square.Item;

/**
 *
 * @author Tobias
 * @revised Oskar
 */
public class ClassicModel extends AbstractGameModel{
    
    private GameTimer gameTimer = null;
    
    public enum Visibility{
    	
    	EMPTY(true),ONE(true),TWO(true),THREE(true),FOUR(true),
        FIVE(true),SIX(true),SEVEN(true),EIGHT(true),
        SQUARE(false),FLAG(false),UNKNOWN(false),MINE(true);
    	
    	private final boolean showContent;
    	
    	private Visibility(boolean v){
    		showContent=v;
    	}
        
        public boolean showsContent(){
        	return showContent;
        }
    }
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    public void chooseSquare(int xPos, int yPos){
        
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            gameTimer = new GameTimer();
        }
        
        if( getBoard().chooseSquare(xPos, yPos) == Item.MINE){
            gameOver();
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void markSquare(int xPos, int yPos){
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        getBoard().markSquare(xPos, yPos);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void gameOver(){
        gameTimer.stop();
        
        //Save highscore!
        
        
    }

    @Override
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, heigth));
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void restartGame(){
        getBoard().reset();
        gameTimer.stop();
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public Visibility[][] getBoardVisibility(){
        Visibility[][] tmp = new Visibility[getBoard().getHeight()][getBoard().getWidth()];
            for(int i = 0; i<getBoard().getWidth(); i++){
                for(int j = 0; j<getBoard().getHeight(); j++){
                    tmp[j][i]= getVisibility(getBoard().getSquare(i,j));
                }
            }
        return tmp;
    }
    private Visibility getVisibility(Square s){
        if(s.isVisible()){
            if(s.getItem().equals(Item.MINE)){
                return Visibility.MINE;
            }else{
                switch(s.getValue()){
                    case 1:
                        return Visibility.ONE;
                    case 2:
                        return Visibility.TWO;
                    case 3:
                        return Visibility.THREE;
                    case 4:
                        return Visibility.FOUR;
                    case 5:
                        return Visibility.FIVE;
                    case 6:
                        return Visibility.SIX;
                    case 7:
                        return Visibility.SEVEN;
                    case 8:
                        return Visibility.EIGHT;
                }
            }
        }else{
            switch(s.getMarking()){
                case NONE:
                    return Visibility.SQUARE;
                case FLAG:
                    return Visibility.FLAG;
                case QUESTION:
                    return Visibility.UNKNOWN;
            }
        }
        return Visibility.UNKNOWN;
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
}
