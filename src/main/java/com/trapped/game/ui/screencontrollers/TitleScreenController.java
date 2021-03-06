package main.java.com.trapped.game.ui.screencontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.java.com.trapped.game.fxapp.TrappedGame;
import main.java.com.trapped.game.gamedata.Settings;
import main.java.com.trapped.game.model.Action;
import main.java.com.trapped.game.model.Choice;
/**
 * Controls the functionality of TitleScreen.fxml
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class TitleScreenController extends ScreenController {

    @FXML
    private ListView menuChoicesListView;

    @FXML
    private Label authorLabel;

    @FXML
    private Label titleLabel;

    @Override
    public void setup() {
        ObservableList<Choice> menuChoices = FXCollections.observableArrayList(
                new Choice("New Game", new Action() {
                    @Override
                    public void doAction() {
                        myApp.getStoryHandler().progressStory("0-0-00");
                        myApp.setScreen("GameScreen");
                    }
                }),
                new Choice("Load Game", () -> System.out.println("Loading game...")),
                new Choice("Exit", () -> System.exit(21)));
        menuChoicesListView.setItems(menuChoices);
        titleLabel.setText(Settings.GAME_TITLE);
        authorLabel.setText("A game by " + Settings.GAME_AUTHOR);
    }

    @FXML
    private void selectChoice() {
        Choice choice = (Choice) menuChoicesListView.getSelectionModel().getSelectedItem();
        if (choice != null) {
            choice.doAction();
        }
    }

}
