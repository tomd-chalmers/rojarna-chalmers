/**
 * The visualisation of the ClassicModel, uses a gameBoardView.
 * @author Tom
 */

package View;

import Model.AbstractGameModel;
import Model.ClassicModel;
import Model.Save;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class ClassicView extends javax.swing.JPanel implements PropertyChangeListener,Observer{
    
    
    private ClassicModel model;
    private GameBoardView gameBoard;
    private String boardSize="small";
    /**
     * Creates new form ClassicView
     */
    public ClassicView(ClassicModel m) {
        initComponents();
        
        model = m;
        model.addObserver(this);
        
        this.gameBoard=new GameBoardView(this.model, this);
        boardCard.add(gameBoard);
        
        gamePanel.add(boardCard,"board");
        boardCard.setBackground(Color.red);
        gamePanel.add(pausCard,"pause");
        
        smallRadio.setSelected(true);
        
        showHighscore();
    }
    private void newGame(){
        boardCard.remove(gameBoard);
        
        if(boardSize.equals("small")){
            model = new ClassicModel();
        }else if(boardSize.equals("medium")){
            model = new ClassicModel(40,16,16);
        }else if(boardSize.equals("large")){
            model = new ClassicModel(99,30,16);
        }else{
            System.out.println("error in size.");
        }
        
        this.gameBoard=new GameBoardView(this.model, this);
        boardCard.add(gameBoard);
        
        model.addObserver(this);
        
        showHighscore();
        gamePanel.updateUI();
    }
    
    public void restartGame(){
        model.restartGame();
        gamePanel.updateUI();
    }
    
    private void exitGame(){
        int answer = JOptionPane.showConfirmDialog(this, "Du ska väl inte sluta än?",
                "Varning", JOptionPane.OK_CANCEL_OPTION);
        
        if(answer == JOptionPane.OK_OPTION){
            this.firePropertyChange("MainMenu", false, true);
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
            secondPlaceLabel.setText(list.get(1)+"");
        }
        else{
            secondPlaceLabel.setText("0");
                    
        }
        if(list.size()>2){
            thirdPlaceLabel.setText(list.get(2)+"");
        }
        else{
            thirdPlaceLabel.setText("0");
                    
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

        gamePanel = new javax.swing.JPanel();
        boardCard = new javax.swing.JPanel();
        pausCard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sideMenu = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(32767, 25));
        timeLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        highScorePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstPlaceLabel = new javax.swing.JLabel();
        secondPlaceLabel = new javax.swing.JLabel();
        thirdPlaceLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        smallRadio = new javax.swing.JRadioButton();
        mediumRadio = new javax.swing.JRadioButton();
        largeRadio = new javax.swing.JRadioButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel1 = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pausButton = new javax.swing.JToggleButton();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(400, 340));
        setLayout(new java.awt.BorderLayout());

        gamePanel.setLayout(new java.awt.CardLayout());
        gamePanel.add(boardCard, "card2");

        pausCard.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Game Paused");
        pausCard.add(jLabel1, java.awt.BorderLayout.CENTER);

        gamePanel.add(pausCard, "card3");

        add(gamePanel, java.awt.BorderLayout.CENTER);

        sideMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sideMenu.setMaximumSize(new java.awt.Dimension(200, 37285));
        sideMenu.setMinimumSize(new java.awt.Dimension(200, 138));
        sideMenu.setPreferredSize(new java.awt.Dimension(200, 138));
        sideMenu.setLayout(new javax.swing.BoxLayout(sideMenu, javax.swing.BoxLayout.PAGE_AXIS));
        sideMenu.add(filler2);

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel.setText("Time");
        timeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        timeLabel.setMaximumSize(new java.awt.Dimension(100, 29));
        timeLabel.setMinimumSize(new java.awt.Dimension(100, 29));
        timeLabel.setPreferredSize(new java.awt.Dimension(100, 29));
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sideMenu.add(timeLabel);
        sideMenu.add(filler1);

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

        sideMenu.add(highScorePanel);

        jPanel5.setLayout(new java.awt.GridLayout(3, 1));

        smallRadio.setText("Small");
        smallRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallRadioActionPerformed(evt);
            }
        });
        jPanel5.add(smallRadio);

        mediumRadio.setText("Medium");
        mediumRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumRadioActionPerformed(evt);
            }
        });
        jPanel5.add(mediumRadio);

        largeRadio.setText("Large");
        largeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeRadioActionPerformed(evt);
            }
        });
        jPanel5.add(largeRadio);

        sideMenu.add(jPanel5);
        sideMenu.add(filler3);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        jPanel1.add(newGameButton);

        jButton1.setText("Restart Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        pausButton.setText("Pause");
        pausButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pausButton);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ExitButton);

        sideMenu.add(jPanel1);

        add(sideMenu, java.awt.BorderLayout.WEST);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void pausButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausButtonActionPerformed
        if(pausButton.isSelected()==true){ // pause!
            model.pauseGame(true);
            
            CardLayout cardLayout = (CardLayout) gamePanel.getLayout();
            cardLayout.show(gamePanel,"pause");
        }else if(pausButton.isSelected()==false){ //unpause!
            model.pauseGame(false);
            
            CardLayout cardLayout = (CardLayout) gamePanel.getLayout();
            cardLayout.show(gamePanel,"board");
        }
    }//GEN-LAST:event_pausButtonActionPerformed

    private void smallRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallRadioActionPerformed
        if(mediumRadio.isSelected()){
            mediumRadio.setSelected(false);
        }
        if(largeRadio.isSelected()){
            largeRadio.setSelected(false);
        }
        
        boardSize="small";
    }//GEN-LAST:event_smallRadioActionPerformed

    private void mediumRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumRadioActionPerformed
        if(smallRadio.isSelected()){
            smallRadio.setSelected(false);
        }
        if(largeRadio.isSelected()){
            largeRadio.setSelected(false);
        }
        
        boardSize="medium";
    }//GEN-LAST:event_mediumRadioActionPerformed

    private void largeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeRadioActionPerformed
        if(mediumRadio.isSelected()){
            mediumRadio.setSelected(false);
        }
        if(smallRadio.isSelected()){
            smallRadio.setSelected(false);
        }
        
        boardSize="large";
    }//GEN-LAST:event_largeRadioActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        newGame();
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        exitGame();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        restartGame();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel boardCard;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel firstPlaceLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel highScorePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton largeRadio;
    private javax.swing.JRadioButton mediumRadio;
    private javax.swing.JButton newGameButton;
    private javax.swing.JToggleButton pausButton;
    private javax.swing.JPanel pausCard;
    private javax.swing.JLabel secondPlaceLabel;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JRadioButton smallRadio;
    private javax.swing.JLabel thirdPlaceLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
    
    
    public void propertyChange(PropertyChangeEvent evt) {
        String command = evt.getPropertyName();
        
        if(command.equals("leftClick")){
            SquareView view = (SquareView)evt.getNewValue();
            model.chooseSquare(view.getXPos(), view.getYPos());
            
            if(model.getGameState().equals(ClassicModel.GameState.GAMEWON)){
                Save.saveClassic(model.getGameTime());
                int gameWinOption = JOptionPane.showConfirmDialog(null,"Congratulations, "
                        + "you won this round.\nPlay another one?","Game Over",YES_NO_OPTION);
                
                if(gameWinOption == JOptionPane.YES_OPTION){
                    newGame();
                }else{
                    exitGame();
                }
            }
            
            if(model.getGameState().equals(ClassicModel.GameState.GAMELOST)){
                int gameOverOption = JOptionPane.showConfirmDialog(null,"You've lost this round!\nPlay another "
                        + "game?","Game Over",YES_NO_OPTION);

                if(gameOverOption == JOptionPane.YES_OPTION){
                    newGame();
                }else{
                    exitGame();
                }
            }
        }else if(command.equals("rightClick")){
            SquareView view = (SquareView)evt.getNewValue();
            model.markSquare(view.getXPos(), view.getYPos());
        }
    }

    public void setGameModel(AbstractGameModel m) {
        try{
            model = (ClassicModel)m;
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException();
        }
    }

    public void update(Observable o, Object arg) {
         timeLabel.setText(model.getGameTime()+"");
    }
}
