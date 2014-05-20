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
 * @revised Tom
 */
public class ClassicModel extends AbstractGameModel{
    private GameState state;
    
    public enum GameState{
        PLAYING, PAUSED, GAMEWON, GAMELOST;
    }
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    public void newGame(int mines, int width, int heigth) {
        if(mines < 0 || width < 0 || heigth < 0)
            throw new IllegalArgumentException();
        
        setBoard(new GameBoard(mines, width, heigth));
        state = GameState.PLAYING;
        //toms edit test:
        setGameTimer(new GameTimer());
        //slut
        this.setChanged();
        this.notifyObservers();
    }
    
    public void chooseSquare(int xPos, int yPos){
        if(state.equals(GameState.PLAYING)){
            if(xPos < 0 || yPos < 0)
                throw new IllegalArgumentException();

            if(!getBoard().isClicked()){
                setGameTimer(new GameTimer());
                getGameTimer().start();

            }
            if(getBoard().chooseSquare(xPos, yPos) == Item.MINE &&
                    !getBoard().getSquareMarking(xPos, yPos).equals(Square.Marking.FLAG)){
                
                gameOver(false);
                pauseGame(true);
            } else if( getBoard().isAllNumberShown() ){
                gameOver(true);
                pauseGame(true);
            }

            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public void markSquare(int xPos, int yPos){
        if(state.equals(GameState.PLAYING)){
            if(xPos < 0 || yPos < 0)
                throw new IllegalArgumentException();

            getBoard().markSquare(xPos, yPos);

            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public void gameOver(boolean gameWon){
        getGameTimer().stop();
        
        if(gameWon){
            //Save.saveClassic(getMines());
            setGameState(GameState.GAMEWON);
        } else{
            getBoard().showMines(true);
            setGameState(GameState.GAMELOST);
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void restartGame(){
        state = GameState.PLAYING;
        getBoard().reset();
        getGameTimer().stop();
        
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public void pauseGame(boolean pause){
        if(state.equals(GameState.PAUSED)||state.equals(GameState.PLAYING)){
            super.pauseGame(pause);
            
            if(pause){
                state = GameState.PAUSED;
            }else{
                state = GameState.PLAYING;
            }
            
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
    
    private void setGameState(GameState gameState){
        state = gameState;
    }
    
    public GameState getGameState(){
        return state;
    }
}
