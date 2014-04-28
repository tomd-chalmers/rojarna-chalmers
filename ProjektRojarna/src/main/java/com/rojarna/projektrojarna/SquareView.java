/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Oskar
 */
public class SquareView extends javax.swing.JPanel implements Observer{
    
    private AbstractGameModel model;
    private int x;
    private int y;
    private boolean setBoard = false;

    /**
     * Creates new form SquareView
     */
    public SquareView(AbstractGameModel model, int x, int y) {
        
        this.model=model;
        this.x=x;
        this.y=y;
        
        model.addObserver(this);
        
        initComponents();
        contentLabel = new JLabel();
        contentCard.add(contentLabel);
        
        CardLayout c = (CardLayout)(this.getLayout());
        c.show(this,"button");

        
    }
    
    private void setContent(Square s){
        if(s.getItem()==Square.Item.MINE){
            contentLabel.setIcon(new ImageIcon(""));
            contentLabel.setText("*");
        }else{
            switch(s.getValue()){
                case 0:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-0.png"));
                    break;
                case 1:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-1.png"));
                    break;
                case 2:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-2.png"));
                    break;
                case 3:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-3.png"));
                    break;
                case 4:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-4.png"));
                    break;
                case 5:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-5.png"));
                    break;
                case 6:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-6.png"));
                    break;
                case 7:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-7.png"));
                    break;
                case 8:
                    contentLabel.setIcon(new ImageIcon("src/resources/nbr-8.png"));
                    break;
            }
        }
    }
    
    private void setButtonIcon(Square.Marking m){
        switch(m){
            case NONE:
                button.setIcon(new ImageIcon(""));
                button.setText("");
                break;
            case FLAG:
                button.setIcon(new ImageIcon(""));
                button.setText("F");
                break;
            case QUESTION:
                button.setIcon(new ImageIcon(""));
                button.setText("?");
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentCard = new javax.swing.JPanel();
        buttonCard = new javax.swing.JPanel();
        button = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        contentCard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contentCard.setLayout(new java.awt.GridBagLayout());
        add(contentCard, "content");

        buttonCard.setLayout(new java.awt.GridLayout(1, 1));

        button.setMaximumSize(new java.awt.Dimension(40, 40));
        button.setMinimumSize(new java.awt.Dimension(40, 40));
        button.setPreferredSize(new java.awt.Dimension(40, 40));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
        });
        buttonCard.add(button);

        add(buttonCard, "button");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed
        if (evt.getButton()==1){ //Vänsterklick
            model.chooseSquare(x,y);
        }else if(evt.getButton()==3){ //Högerklick
            model.markSquare(x,y);
        }
    }//GEN-LAST:event_buttonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JPanel buttonCard;
    private javax.swing.JPanel contentCard;
    // End of variables declaration//GEN-END:variables
    private JLabel contentLabel;

    public void update(Observable o, Object arg) {
        System.out.println("Updated!");
        if(model.getSquare(x,y).isVisible()){
            setContent(model.getSquare(x,y));
            CardLayout c = (CardLayout)(this.getLayout());
            c.show(this,"content");
        }else{
            CardLayout c = (CardLayout)(this.getLayout());
            c.show(this,"button");
            setButtonIcon(model.getSquare(x,y).getMarking());
        }
    }
}
