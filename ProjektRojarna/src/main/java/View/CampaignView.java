/**
 * The view for CampaignModel, uses the view from GameBoard to illustrate 
 * the game in grafic to the player.
 * @author Oskar
 */

package View;

import Model.AbstractGameModel;
import Model.CampaignModel;
import Model.CampaignModel.State;
import Model.PUChooseRandomFour;
import Model.PUChooseSafeArea;
import Model.PUChooseSafeSingle;
import Model.PowerupInterface;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class CampaignView extends javax.swing.JPanel implements PropertyChangeListener, Observer{
    
    private CampaignModel model;
    private PowerupInterface PU1 = new PUChooseSafeArea();
    private PUChooseRandomFour PU2 = new PUChooseRandomFour();
    private PowerupInterface PU3 = new PUChooseSafeSingle();
    GameBoardView board;

    /**
     * Creates new form ModelView
     */
    public CampaignView(CampaignModel m) {
        initComponents();
        
        model= m;
        model.addObserver(this);
        board = new GameBoardView(model, this);
        boardCard.add(board);
        boardCard.setBackground(Color.CYAN);
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
        timePanel = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        levelPanel = new javax.swing.JPanel();
        levelLabel = new javax.swing.JLabel();
        lifePanel = new javax.swing.JPanel();
        lifeLabel1 = new javax.swing.JLabel();
        lifeLabel2 = new javax.swing.JLabel();
        lifeLabel3 = new javax.swing.JLabel();
        minePanel = new javax.swing.JPanel();
        nbrOfFlags = new javax.swing.JLabel();
        flagIconLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nbrOfMines = new javax.swing.JLabel();
        mineIconLabel = new javax.swing.JLabel();
        PUPanel = new javax.swing.JPanel();
        PUButton1 = new javax.swing.JToggleButton();
        PUButton2 = new javax.swing.JToggleButton();
        PUButton3 = new javax.swing.JToggleButton();
        StatePanel = new javax.swing.JPanel();
        testLabel = new javax.swing.JLabel();
        buttonCardPanel = new javax.swing.JPanel();
        PausButtonCard = new javax.swing.JPanel();
        pausButton = new javax.swing.JToggleButton();
        newGameButtonCard = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        nextLevelButtonCard = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        ExitButtonPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        boardCard = new javax.swing.JPanel();
        pausCard = new javax.swing.JPanel();
        pausLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuPanel.setMaximumSize(new java.awt.Dimension(200, 32767));
        menuPanel.setMinimumSize(new java.awt.Dimension(200, 408));
        menuPanel.setPreferredSize(new java.awt.Dimension(200, 408));
        menuPanel.setLayout(new java.awt.GridLayout(8, 1));

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timeLabel.setText("Time");
        timePanel.add(timeLabel);

        menuPanel.add(timePanel);

        levelLabel.setText("Level");
        levelPanel.add(levelLabel);

        menuPanel.add(levelPanel);

        lifePanel.add(lifeLabel1);
        lifePanel.add(lifeLabel2);
        lifePanel.add(lifeLabel3);

        menuPanel.add(lifePanel);

        nbrOfFlags.setText("Flags");
        minePanel.add(nbrOfFlags);

        flagIconLabel.setIcon(new ImageIcon("src/resources/flag.png"));
        minePanel.add(flagIconLabel);

        jLabel2.setText("/");
        minePanel.add(jLabel2);

        nbrOfMines.setText("Mines");
        minePanel.add(nbrOfMines);

        mineIconLabel.setIcon(new ImageIcon("src/resources/mine.16.png"));
        minePanel.add(mineIconLabel);

        menuPanel.add(minePanel);

        PUPanel.setLayout(new java.awt.GridBagLayout());

        PUButton1.setText("PU1");
        PUButton1.setToolTipText("Välj ett område och låt datort säkert räkna ut var minorna finns. Kostar: 30 sec");
        PUButton1.setFocusable(false);
        PUButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton1ActionPerformed(evt);
            }
        });
        PUPanel.add(PUButton1, new java.awt.GridBagConstraints());

        PUButton2.setText("PU2");
        PUButton2.setToolTipText("Väljer 4 slumpmäsiga ruton och flagar dom ifall det är minor. Kostar: 15 sec");
        PUButton2.setFocusable(false);
        PUButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton2ActionPerformed(evt);
            }
        });
        PUPanel.add(PUButton2, new java.awt.GridBagConstraints());

        PUButton3.setText("PU3");
        PUButton3.setToolTipText("Välj en ruta utan att förlora ett liv om det är en mina. Kostar: 5 sec");
        PUButton3.setFocusable(false);
        PUButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUButton3ActionPerformed(evt);
            }
        });
        PUPanel.add(PUButton3, new java.awt.GridBagConstraints());

        menuPanel.add(PUPanel);

        testLabel.setText("jLabel1");
        StatePanel.add(testLabel);

        menuPanel.add(StatePanel);

        buttonCardPanel.setLayout(new java.awt.CardLayout());

        pausButton.setText("Paus");
        pausButton.setFocusable(false);
        pausButton.setPreferredSize(new java.awt.Dimension(80, 35));
        pausButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausButtonActionPerformed(evt);
            }
        });
        PausButtonCard.add(pausButton);

        buttonCardPanel.add(PausButtonCard, "paus");

        jButton1.setText("Nytt Spel");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        newGameButtonCard.add(jButton1);

        buttonCardPanel.add(newGameButtonCard, "newGame");

        jButton3.setText("Fortsätt");
        jButton3.setPreferredSize(new java.awt.Dimension(80, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        nextLevelButtonCard.add(jButton3);

        buttonCardPanel.add(nextLevelButtonCard, "continue");

        menuPanel.add(buttonCardPanel);

        jButton2.setText("Avsluta");
        jButton2.setFocusable(false);
        jButton2.setPreferredSize(new java.awt.Dimension(80, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ExitButtonPanel.add(jButton2);

        menuPanel.add(ExitButtonPanel);

        add(menuPanel, java.awt.BorderLayout.WEST);

        cardPanel.setMinimumSize(new java.awt.Dimension(100, 408));
        cardPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(boardCard, "card2");

        pausCard.setLayout(new java.awt.BorderLayout());

        pausLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pausLabel.setIcon(new ImageIcon(getClass().getResource("/images/paus.png")));
        pausLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pausCard.add(pausLabel, java.awt.BorderLayout.CENTER);

        cardPanel.add(pausCard, "card3");

        add(cardPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void PUButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton1ActionPerformed
        if(PUButton3.isSelected()){
            PUButton3.setSelected(false);
        }
    }//GEN-LAST:event_PUButton1ActionPerformed

    private void PUButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton2ActionPerformed
        model.usePowerup(PU2,0,0);
        PUButton2.setSelected(false);
    }//GEN-LAST:event_PUButton2ActionPerformed

    private void PUButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUButton3ActionPerformed
        if(PUButton1.isSelected()){
            PUButton1.setSelected(false);
        }
    }//GEN-LAST:event_PUButton3ActionPerformed

    private void pausButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausButtonActionPerformed
        model.pauseGame(pausButton.isSelected());
        CardLayout tmp = (CardLayout) cardPanel.getLayout();
        if(model.isGamePaused()){
            tmp.last(cardPanel);
        }else{
            tmp.first(cardPanel);
        }
    }//GEN-LAST:event_pausButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout tmp = (CardLayout) buttonCardPanel.getLayout();
        tmp.show(buttonCardPanel,"paus");
        restart();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, "Du ska väl inte sluta än?",
                "Varning", JOptionPane.OK_CANCEL_OPTION);
        
        if(answer == JOptionPane.OK_OPTION){
            this.firePropertyChange("MainMenu", false, true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout tmp = (CardLayout) buttonCardPanel.getLayout();
        tmp.show(buttonCardPanel,"paus");
        model.nextLevel();
        board.renewBoard(this);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExitButtonPanel;
    private javax.swing.JToggleButton PUButton1;
    private javax.swing.JToggleButton PUButton2;
    private javax.swing.JToggleButton PUButton3;
    private javax.swing.JPanel PUPanel;
    private javax.swing.JPanel PausButtonCard;
    private javax.swing.JPanel StatePanel;
    private javax.swing.JPanel boardCard;
    private javax.swing.JPanel buttonCardPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel flagIconLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JPanel levelPanel;
    private javax.swing.JLabel lifeLabel1;
    private javax.swing.JLabel lifeLabel2;
    private javax.swing.JLabel lifeLabel3;
    private javax.swing.JPanel lifePanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel mineIconLabel;
    private javax.swing.JPanel minePanel;
    private javax.swing.JLabel nbrOfFlags;
    private javax.swing.JLabel nbrOfMines;
    private javax.swing.JPanel newGameButtonCard;
    private javax.swing.JPanel nextLevelButtonCard;
    private javax.swing.JToggleButton pausButton;
    private javax.swing.JPanel pausCard;
    private javax.swing.JLabel pausLabel;
    private javax.swing.JLabel testLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables

    public void propertyChange(PropertyChangeEvent evt) {
        String command = evt.getPropertyName();
        if(command.equals("leftClick")){
            SquareView view = (SquareView)evt.getNewValue();
            if(PUButton1.isSelected()){
                model.usePowerup(PU1,view.getXPos(), view.getYPos());
                PUButton1.setSelected(false);
            }else if(PUButton3.isSelected()){
                model.usePowerup(PU3, view.getXPos(),view.getYPos());
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
        if(model.getState().equals(State.GAMEOVER)&&!newGameButtonCard.isVisible()){
            int choise = JOptionPane.showConfirmDialog(null, 
                "Do you want to restart?", "GAME OVER", JOptionPane.YES_NO_OPTION,0,new ImageIcon(getClass().getResource("/images/boom.png")));
            if(choise==0){
                restart();
            }else{
                CardLayout tmp = (CardLayout) buttonCardPanel.getLayout();
                tmp.show(buttonCardPanel,"newGame");
            }
        }else if(model.getState().equals(State.FINISHED)&&!nextLevelButtonCard.isVisible()){
            int choise = JOptionPane.showConfirmDialog(null,
                "Start level "+(model.getLevel()+1)+"?","Level "+model.getLevel()+" cleared!"
                    , JOptionPane.YES_NO_OPTION,0,new ImageIcon(getClass().getResource("/images/win.png")));
            if(choise==0){
                model.nextLevel();
                board.renewBoard(this);
            }else{
                CardLayout tmp = (CardLayout) buttonCardPanel.getLayout();
                tmp.show(buttonCardPanel,"continue");
                
            }
        }
        labelUpdate();
    }
    
    private void labelUpdate(){
        timeLabel.setText(model.getGameTime()+"");
        levelLabel.setText("Level: "+model.getLevel());
        setLives(model.getLives());
        nbrOfMines.setText(model.getMines()+"");
        nbrOfFlags.setText(model.getFlags()+"");
        testLabel.setText(model.getState()+"");
        PUButton1.setEnabled(PU1.getCost()<model.getGameTime());
        PUButton2.setEnabled(PU2.getCost()<model.getGameTime());
        PUButton3.setEnabled(PU3.getCost()<model.getGameTime());
    }
    
    private void setLives(int lives){
        if(lives>0){
            lifeLabel1.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
            if(lives>1){
                lifeLabel2.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
                if(lives>2){
                    lifeLabel3.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
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
        CardLayout tmp = (CardLayout) cardPanel.getLayout();
        tmp.first(cardPanel);
        
        revalidate();

        
    }

    public void setGameModel(AbstractGameModel m) {
        try{
            model = (CampaignModel)m;
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException();
        }
        
        model.addObserver(this);
    }
}
