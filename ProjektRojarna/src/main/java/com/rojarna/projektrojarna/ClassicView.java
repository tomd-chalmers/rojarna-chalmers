/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Tom
 */
public class ClassicView extends javax.swing.JPanel implements PropertyChangeListener{
    
    
    private ClassicModel model;
    GameBoardView gameBoard;
    /**
     * Creates new form ClassicView
     */
    public ClassicView(ClassicModel m) {
        initComponents();
        
        gamePanel.setLayout(new FlowLayout());
        this.model=m;
        this.gameBoard=new GameBoardView(this.model, this);
        gamePanel.add(gameBoard);
        //gamePanel.add(new JLabel("test"));
        showHighscore();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        highScorePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstPlaceLabel = new javax.swing.JLabel();
        secondPlaceLabel = new javax.swing.JLabel();
        thirdPlaceLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        PauseButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(400, 340));
        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        add(gamePanel, java.awt.BorderLayout.CENTER);

        jPanel1.setMaximumSize(new java.awt.Dimension(100, 138));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 138));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 138));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jPanel2.setLayout(new java.awt.GridBagLayout());

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel.setText("Time");
        jPanel2.add(timeLabel, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("HIGHSCORE");

        jLabel3.setText("1.");

        jLabel4.setText("2.");

        jLabel5.setText("3.");

        firstPlaceLabel.setText("jLabel6");

        secondPlaceLabel.setText("jLabel7");

        thirdPlaceLabel.setText("jLabel8");

        javax.swing.GroupLayout highScorePanelLayout = new javax.swing.GroupLayout(highScorePanel);
        highScorePanel.setLayout(highScorePanelLayout);
        highScorePanelLayout.setHorizontalGroup(
            highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScorePanelLayout.createSequentialGroup()
                .addGroup(highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(highScorePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(highScorePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(highScorePanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstPlaceLabel))
                            .addGroup(highScorePanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(secondPlaceLabel))))
                    .addGroup(highScorePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(thirdPlaceLabel)))
                .addContainerGap())
        );
        highScorePanelLayout.setVerticalGroup(
            highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(firstPlaceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(secondPlaceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(highScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(thirdPlaceLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(highScorePanel, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        PauseButton.setText("PAUSE");
        jPanel4.add(PauseButton);

        ExitButton.setText("EXIT");
        jPanel4.add(ExitButton);

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.WEST);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton PauseButton;
    private javax.swing.JLabel firstPlaceLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel highScorePanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel secondPlaceLabel;
    private javax.swing.JLabel thirdPlaceLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
    
    public void propertyChange(PropertyChangeEvent evt) {
        String command = evt.getPropertyName();
        //timeLabel.setText(model.getGameTime()+"");
        if(command.equals("leftClick")){
            SquareView view = (SquareView)evt.getNewValue();
            model.chooseSquare(view.getXPos(), view.getYPos());                
        }else if(command.equals("rightClick")){
            SquareView view = (SquareView)evt.getNewValue();
            model.markSquare(view.getXPos(), view.getYPos());
        }
    }
    private void showHighscore(){
        
        List<Integer> list = Save.getHighscore();
        if(list.size()>0){
            firstPlaceLabel.setText(list.get(0)+"");
        }
        else{
            firstPlaceLabel.setText("0");
                    
        }
        if(list.size()>1){
            secondPlaceLabel.setText(list.get(0)+"");
        }
        else{
            secondPlaceLabel.setText("0");
                    
        }
        if(list.size()>2){
            thirdPlaceLabel.setText(list.get(0)+"");
        }
        else{
            thirdPlaceLabel.setText("0");
                    
        }
    }
}
