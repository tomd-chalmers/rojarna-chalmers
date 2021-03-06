/**
 * The "rules" for the classic game mode, creates and uses a gameboard.
 * 
 * @author Tobias
 * @revised Oskar
 * @revised Tom
 */

package Model;

import Model.Square.Item;


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
        
        setGameTimer(new GameTimer());
        
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
            
            if(!(getBoard().getSquareMarking(xPos, yPos).equals(Square.Marking.FLAG))){
                if(getBoard().chooseSquare(xPos, yPos) == Item.MINE){
                    gameOver(false);
                    pauseGame(true);
                } else if( getBoard().isAllNumberShown() ){
                    gameOver(true);
                    pauseGame(true);
                }
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