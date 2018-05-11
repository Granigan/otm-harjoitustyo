package podship.gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import podship.logic.GameLogic;

/**
 * The main screen of the game. Describes the event and allows the player to
 * make choices by clicking buttons corresponding to Options. Contains buttons
 * for options, quit and go back to main menu, text field for event description
 * and another for backlog of choices (TBA).
 */
public class TurnScene extends BaseScene {

    private Button chooseFirst;
    private Button chooseSecond;
    private Button chooseThird;
    private TextArea eventScreen;

    public TurnScene(SceneManager manager, GameLogic logic) {
        super(manager, logic);
    }

    public void buildScene() {
        chooseFirst = optionButtonSetup("I understand.", 201, "0");
        chooseSecond = optionButtonSetup("Let's get started.", 334, "1");
        chooseThird = optionButtonSetup("I will not fail!", 467, "2");

        Button menuButton = new Button("Leave Game");
        Button exitButton = new Button("Exit");

        menuButton.setLayoutX(100);
        menuButton.setLayoutY(350);
        menuButton.setPrefSize(100, 50);

        exitButton.setLayoutX(0);
        exitButton.setLayoutY(350);
        exitButton.setPrefSize(100, 50);

        eventScreen = new TextArea();
        eventScreen.setLayoutX(200);
        eventScreen.setLayoutY(0);
        eventScreen.setPrefSize(400, 300);
        eventScreen.wrapTextProperty().set(true);
        eventScreen.setText(logic.getTurnLogic().getIntroText());

        layout.getChildren().addAll(chooseFirst, chooseSecond, chooseThird,
                menuButton, exitButton,
                eventScreen);
        scene = new Scene(layout);

        menuButton.setOnAction(e -> manager.setScene("start"));
        exitButton.setOnAction(e -> Platform.exit());

    }

    /**
     * Formats an Option button.
     *
     * @param text sets this as starting text
     * @param x defines the x coordinate
     * @param id gives button the id that's used with reporting user choice to
     * logic
     * @return returns the formatted Button
     */
    public Button optionButtonSetup(String text, int x, String id) {
        Button b = new Button(text);
        b.setPrefSize(133, 100);
        b.setLayoutX(x);
        b.setLayoutY(300);
        b.wrapTextProperty().set(true);
        b.setId(id);
        b.setOnAction(e -> optionChosen(Integer.parseInt(id)));
        return b;
    }

    /**
     * Option button event, reports to logic the id of the button, ie. which
     * option was chosen.
     *
     * @param id
     */
    public void optionChosen(int id) {
        logic.selectionMade(id);
    }

    /**
     * Used to epdate the texts on event description and option buttons after a
     * choice has been made to show the new event and options.
     *
     * @param firstOption is the text in the first option button
     * @param secondOption is the text in the second option button
     * @param thirdOption is the text in the third option button
     * @param eventText is the event description
     */
    public void setEventTexts(String firstOption, String secondOption,
            String thirdOption, String eventText) {
        chooseFirst.setText(firstOption);
        chooseSecond.setText(secondOption);
        chooseThird.setText(thirdOption);
        eventScreen.setText(eventText);
    }

    /**
     * Sets all the option button events to trigger a switch to travel phase
     *
     */
    public void initiateLaunch() {
        chooseFirst.setOnAction(e -> launched());
        chooseSecond.setOnAction(e -> launched());
        chooseThird.setOnAction(e -> launched());
    }

    /**
     * Triggers the switch from build/turn phase to travel phase.
     *
     */
    public void launched() {
        manager.setScene("travel");
        logic.beginVoyage();
    }

}
