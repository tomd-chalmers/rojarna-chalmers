/**
 * The controller of this MVC based application. GameController main purpose is 
 * to provide the user with input by arranging for relevant views to present
 * themselves in appropriate places on the screen
 * 
 * @author Tobias
 */

package Controller;

import Model.ClassicModel;
import Model.AbstractGameModel;
import Model.CampaignModel;
import View.ClassicView;
import View.CampaignView;
import View.GameFrame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;


public class GameController implements Observer, PropertyChangeListener{
    
    private AbstractGameModel gameModel = null;
    private GameFrame frame = null;
    
    public GameController(){
        frame = new GameFrame();
        
        frame.setVisible(true);
        frame.pack();
        frame.addPropertyChangeListener(this);
    }
    
    public GameController(AbstractGameModel model){
        gameModel = model;
        model.addObserver(this);
    }
    
    private void exitProgram(){
        frame.setEnabled(false);
        frame.dispose();
        System.exit(0);
    }

    public void update(Observable o, Object arg) {
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ClassicGame")){
            gameModel = new ClassicModel();
            gameModel.addObserver(this);
            
            ClassicView v = new ClassicView((ClassicModel)gameModel);
            v.addPropertyChangeListener(this);
            
            frame.setGamePanel(v);
            frame.showGameBoard();
        }
        else if(evt.getPropertyName().equals("CampaignGame")){
            gameModel = new CampaignModel();
            gameModel.addObserver(this);
            
            CampaignView v = new CampaignView((CampaignModel)gameModel);
            v.addPropertyChangeListener(this);
            
            frame.setGamePanel(v);
            frame.showGameBoard();
        }
        else if(evt.getPropertyName().equals("ExitGame")){
            exitProgram();
        }
        else if(evt.getPropertyName().equals("MainMenu")){
            gameModel.pauseGame(true);
            frame.showGameMenu();
        }
    }
}
