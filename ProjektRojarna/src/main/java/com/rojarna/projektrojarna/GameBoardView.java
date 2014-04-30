/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;

/**
 *
 * @author Tom
 */
public class GameBoardView extends javax.swing.JPanel{
    /**
     * Creates new form GameBoardView
     */
    
    private AbstractGameModel model;
    
    public GameBoardView(AbstractGameModel model) {
        initComponents();
        
        this.model = model;
        setLayout(new java.awt.GridLayout(model.getWidth(),model.getHeight()));
        
        for(int x=0;x<model.getWidth();x++){
            for(int y=0;y<model.getHeight();y++){
                SquareView s = new SquareView(model,x,y);
                add(s);
            }
        }
    }
    
    public void enableView(boolean enable){
        //isEnabled(enable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
