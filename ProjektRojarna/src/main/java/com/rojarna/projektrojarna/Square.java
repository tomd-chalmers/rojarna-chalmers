/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Tobias Foughman Lind
 */
public class Square {
    
    private boolean isVisible;
    
    private Marking marking;
    private State currentState;
    
    
    private enum State{
        EMPTY, ONE, TWO, THREE, FOUR, 
        FIVE, SIX, SEVEN, EIGHT, MINE;
        
        public int getValue(){
            switch(this){
                case ONE:
                    return 1;
                case TWO:
                    return 2;
                case THREE:
                    return 3;
                case FOUR:
                    return 4;
                case FIVE:
                    return 5;
                case SIX:
                    return 6;
                case SEVEN:
                    return 7;
                case EIGHT:
                    return 8;
            }
            
            return 0;
        }
    }
    
    private enum Marking{
        NONE, FLAG, QUESTION;
    }
    
    public Square(){
        marking = Marking.NONE;
        setState(State.EMPTY);
    }
    
    public void setState(State state){
        currentState = state;
    }
    
    public State getState(){
        return currentState;
    }
    
    public void markSquare(){
        if(!isVisible){
            if(marking == Marking.NONE){
                marking = Marking.FLAG;
            }
            else if(marking == Marking.FLAG){
                marking = Marking.QUESTION;
            }
            else{
                marking = Marking.NONE;
            }
        }
    }
    
    public Marking getMarking(){
        return marking;
    }
    
    public void increaseState(){
        switch(getState()){
            case ONE:
                currentState = State.TWO;
            case TWO:
                currentState = State.THREE;
            case THREE:
                currentState = State.FOUR;
            case FOUR:
                currentState = State.FIVE;
            case FIVE:
                currentState = State.SIX;
            case SIX:
                currentState = State.SEVEN;
            case SEVEN:
                currentState = State.EIGHT;
            case EIGHT:
                currentState = State.ONE;
        }
    }
    
    public void setVisible(boolean value){
        isVisible = value;
    }
    
}
