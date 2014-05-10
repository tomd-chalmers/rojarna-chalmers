/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import com.rojarna.projektrojarna.CampaignModel.state;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Oskar
 */
public class CampaignView extends javax.swing.JPanel implements PropertyChangeListener,Observer{
    
    private CampaignModel model;
    private PowerupInterface PU1 = new PUChooseSafeArea();
    private PowerupInterface PU2 = new PUChooseSafeSingle();
    private PowerupInterface PU3 = new PUShowAll();
    GameBoardView board;

    /**
     * Creates new form ModelView
     */
    public CampaignView() {
        initComponents();
        model= new CampaignModel();
        model.addObserver(this);
        board = new GameBoardView(model, this);
        boardCard.add(board);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        levelLabel = new javax.swing.JLabel();
        lifePanel = new javax.swing.JPanel();
        lifeLabel1 = new javax.swing.JLabel();
        lifeLabel2 = new javax.swing.JLabel();
        lifeLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mineLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        PUButton1 = new javax.swing.JToggleButton();
        PUButton2 = new javax.swing.JToggleButton();
        PUButton3 = new javax.swing.JToggleButton();
        jPanel8 = new javax.swing.JPanel();
        testLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pausButton = new javax.swing.JToggleButton();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        boardCard = new javax.swing.JPanel();
        pausCard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuPanel.setMinimumSize(new java.awt.Dimension(200, 408));
        menuPanel.setPreferredSize(new java.awt.Dimension(200, 408));
        menuPanel.setLayout(new java.awt.GridLayout(8, 1));

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel.setText("Time");
        jPanel3.add(timeLabel);

        menuPanel.add(jPanel3);

        levelLabel.setText("Level");
        jPanel4.add(levelLabel);

        menuPanel.add(jPanel4);

        lifePanel.add(lifeLabel1);
        lifePanel.add(lifeLabel2);
        lifePanel.add(lifeLabel3);

        menuPanel.add(lifePanel);

        jLabel6.setText("MineIcon");
        jPanel6.add(jLabel6);

        mineLabel.setText("nbrOfMines");
        jPanel6.add(mineLabel);

        menuPanel.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        PUButton1.setText("PU1");
        PUButton1.setFocusable(false);
        PUButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(PUButton1, new java.awt.GridBagConstraints());

        PUButton2.setText("PU2");
        PUButton2.setFocusable(false);
        PUButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(PUButton2, new java.awt.GridBagConstraints());

        PUButton3.setText("PU3");
        PUButton3.setFocusable(false);
        PUButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(PUButton3, new java.awt.GridBagConstraints());

        menuPanel.add(jPanel7);

        testLabel.setText("jLabel1");
        jPanel8.add(testLabel);

        menuPanel.add(jPanel8);

        pausButton.setText("Paus");
        pausButton.setFocusable(false);
        pausButton.setPreferredSize(new java.awt.Dimension(80, 35));
        pausButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausButtonActionPerformed(evt);
            }
        });
        jPanel9.add(pausButton);

        menuPanel.add(jPanel9);

        jButton2.setText("Avsluta");
        jButton2.setFocusable(false);
        jButton2.setPreferredSize(new java.awt.Dimension(80, 35));
        jPanel10.add(jButton2);

        menuPanel.add(jPanel10);

        add(menuPanel, java.awt.BorderLayout.WEST);

        cardPanel.setMinimumSize(new java.awt.Dimension(100, 408));
        cardPanel.setPreferredSize(new java.awt.Dimension(200, 408));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(boardCard, "card2");

        pausCard.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Game Paused");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pausCard.add(jLabel1, java.awt.BorderLayout.CENTER);

        cardPanel.add(pausCard, "card3");

        add(cardPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void PUButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton1ActionPerformed
        if(PUButton3.isSelected()){
            PUButton3.setSelected(false);
        }
    }//GEN-LAST:event_PUButton1ActionPerformed

    private void PUButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton2ActionPerformed
        model.usePowerup(new PUShowAll(),0,0);
        PUButton2.setSelected(false);
    }//GEN-LAST:event_PUButton2ActionPerformed

    private void PUButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton3ActionPerformed
        if(PUButton1.isSelected()){
            PUButton1.setSelected(false);
        }
    }//GEN-LAST:event_PUButton3ActionPerformed

    private void pausButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausButtonActionPerformed
        model.pauseGame(pausButton.isSelected());
        pausButton.setSelected(model.isGamePaused());
        CardLayout tmp = (CardLayout) cardPanel.getLayout();
        if(model.isGamePaused()){
            tmp.last(cardPanel);
        }else{
            tmp.first(cardPanel);
        }
    }//GEN-LAST:event_pausButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton PUButton1;
    private javax.swing.JToggleButton PUButton2;
    private javax.swing.JToggleButton PUButton3;
    private javax.swing.JPanel boardCard;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel lifeLabel1;
    private javax.swing.JLabel lifeLabel2;
    private javax.swing.JLabel lifeLabel3;
    private javax.swing.JPanel lifePanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel mineLabel;
    private javax.swing.JToggleButton pausButton;
    private javax.swing.JPanel pausCard;
    private javax.swing.JLabel testLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    public void propertyChange(PropertyChangeEvent evt) {
        String command = evt.getPropertyName();
        if(command.equals("leftClick")){
            SquareView view = (SquareView)evt.getNewValue();
            if(PUButton1.isSelected()){
                model.usePowerup(new PUChooseSafeArea(),view.getXPos(), view.getYPos());
                PUButton1.setSelected(false);
            }else if(PUButton3.isSelected()){
                //Kod för sista PU.
                PUButton3.setSelected(false);
            }else{
            model.chooseSquare(view.getXPos(), view.getYPos());                
            }
            
        }else if(command.equals("rightClick")){
            PUButton1.setSelected(false);
            PUButton3.setSelected(false);
            SquareView view = (SquareView)evt.getNewValue();
            model.markSquare(view.getXPos(), view.getYPos());
        }
        labelUpdate();
    }

    public void update(Observable o, Object arg) {
        labelUpdate();
        if(model.getState().equals(state.GAMEOVER)){
            JOptionPane.showConfirmDialog(null,
            "Restart?", "Restart?", JOptionPane.YES_NO_OPTION);
            restart();
        }
        if(model.getState().equals(state.FINISHED)){
            JOptionPane.showConfirmDialog(null,
            "Play next level?", "Play next level?", JOptionPane.YES_NO_OPTION);
            model.nextLevel();
            board.renewBoard(this);
        }
        labelUpdate();
    }
    
    private void labelUpdate(){
        timeLabel.setText(model.getGameTime()+"");
        levelLabel.setText("Level: "+model.getLevel());
        setLives(model.getLives());
        mineLabel.setText("NA/"+model.getMines());
        testLabel.setText(model.getState()+"");
        PUButton1.setEnabled(PU1.getCost()<model.getGameTime());
        PUButton2.setEnabled(PU2.getCost()<model.getGameTime());
        PUButton3.setEnabled(PU3.getCost()<model.getGameTime());
    }
    
    private void setLives(int lives){
        if(lives>0){
            lifeLabel1.setIcon(new ImageIcon("src/resources/heart.png"));
            if(lives>1){
                lifeLabel2.setIcon(new ImageIcon("src/resources/heart.png"));
                if(lives>2){
                    lifeLabel3.setIcon(new ImageIcon("src/resources/heart.png"));
                }else{
                    lifeLabel3.setIcon(null);
                }
            }else{
                lifeLabel2.setIcon(null);
            }
        }else{
            lifeLabel1.setIcon(null);
        }
    }
    private void restart(){
        model.deleteObserver(this);
        boardCard.removeAll();
        model= new CampaignModel();
        model.addObserver(this);
        GameBoardView board = new GameBoardView(model, this);
        boardCard.add(board);
        this.board=board;

        
    }
}
