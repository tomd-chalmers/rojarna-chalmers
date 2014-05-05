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
    
    private GameTimer gameTimer = null;

    private boolean betweenGames = false;
    private boolean gamePaused = false;
    
    
    public ClassicModel(){
        newGame(10,8,8);
    }
    
    public ClassicModel(int mines, int width, int heigth){
        newGame(mines, width, heigth);
    }
    
    //väldigt basic här bara...
    public void usePowerup(PowerupInterface pu, int x, int y){
        if(gameTimer.afford(pu.getCost())){
            gameTimer.removeTime(pu.getCost());
        } else{
            // Tycker som millhouse, känns bäst att ha koden för afford här.
            System.out.println("NO MONAY!");
        }
        
        pu.power(getBoard(), x, y);
    }
    
    public void chooseSquare(int xPos, int yPos){
        
        if(xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        
        if(!getBoard().isClicked()){
            gameTimer = new GameTimer();
        }
        if( getBoard().chooseSquare(xPos, yPos) == Item.MINE){
            gameOver(false);
            pauseGame(true);
        } else if( getBoard().isAllNumberShown() ){
            gameOver(true);
            pauseGame(true);
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
    
    public void gameOver(boolean gameWon){
        gameTimer.stop();
        
        if(gameWon){
            //Save highscore!
            System.out.println("YOU WON!");
        } else{
            getBoard().showMines();
            System.out.println("YOU LOST!");
        }
        
        betweenGames = true;
        
        this.setChanged();
        this.notifyObservers();
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
    
    public void pauseGame(boolean pause){
        if(pause && !gamePaused){
            gamePaused = true;
            
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public Square getSquare(int x, int y){
        return getBoard().getSquare(x, y);
    }
}
