/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

/**
 *
 * @author Tobias
 * @revised Oskar Frost
 */
public class Square {
	
    private Item item;
    private int value=0;
    private boolean visible=false;
    private Marking mark;
    
    public enum Marking{
        NONE, FLAG, QUESTION;
    }
    	
    public enum Item{
        MINE,NUMBER;
    }

    public Square(){
            item=Item.NUMBER;
            mark=Marking.NONE;
    }
    
    public Item getItem(){
            return item;
    }
    
    public void setItem(Item i){
            item=i;
    }
    
    public void incValue(){
            value++;
    }
    
    public void decValue(){
            value--;
    }
    
    public int getValue(){
            return value;
    }
    
    public boolean isMine(){
            return item.equals(Item.MINE);
    }
    
    public boolean isVisible(){
            return visible;
    }
    
    public void setVisible(boolean visible){
            this.visible=visible;
    }
    
    public void markSquare(){
        if(!visible){
            if(mark == Marking.NONE){
                mark = Marking.FLAG;
            }
            else if(mark == Marking.FLAG){
                mark = Marking.QUESTION;
            }
            else{
                mark = Marking.NONE;
            }
        }
    }
    
    public Marking getMarking(){
        return mark;
    }
}