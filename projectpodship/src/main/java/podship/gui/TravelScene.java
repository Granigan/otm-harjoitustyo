package podship.gui;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import podship.logic.GameLogic;

/**
 * The final/travel phase. Displays player the log of the ship travelling
 * through space, and finally the result of the journey. Contains the text area
 * where the log is generated into, and buttons to quit and leave.
 */
public class TravelScene extends BaseScene {

    private TextArea log;
    private int counter = 0;
    private int cap = 300; // set to ~200 in final
    private AnimationTimer timer;
    private TextArea statScreen;

    /**
     * Constructor links the SceneManager and GameLogic to the scene via 
     * abstract class.
     * @param manager
     * @param logic 
     */
    public TravelScene(SceneManager manager, GameLogic logic) {
        super(manager, logic);
    }

    /**
     * Builds the scene
     */
    public void buildScene() {
        Button exitButton = new Button("Exit");
        Button menuButton = new Button("Back to Menu");

        menuButton.setPrefSize(350, 30);
        exitButton.setPrefSize(50, 30);

        menuButton.setLayoutX(90);
        menuButton.setLayoutY(360);

        exitButton.setLayoutX(500);
        exitButton.setLayoutY(360);

        log = new TextArea();
        log.setPrefSize(400, 340);
        log.setLayoutX(200);
        log.wrapTextProperty().set(true);

        statScreen = new TextArea("");
        statScreen.setPrefSize(200, 300);
        statScreen.setLayoutX(0);
        statScreen.setLayoutY(0);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                counter++;
                if (counter >= cap) {
                    counter -= cap;
                    timer.stop();
                    logic.travel();
                }
            }
        };

        layout.getChildren().addAll(menuButton, exitButton, log, statScreen);
        scene = new Scene(layout);

        menuButton.setOnAction(e -> manager.setScene("start"));
        exitButton.setOnAction(e -> Platform.exit());

    }

    /**
     * Used to append a new event/log entry to the text area, describing the
     * voyage.
     *
     * @param entry is the new log entry to be appended
     */
    public void addLogEntry(String entry, String stats) {
        log.appendText(entry);
        statScreen.setText(stats);
    }

    /**
     * Starts the animation timer to create a brief delay between the events.
     * Once the timer finishes, it calls logic to get a new entry to the log.
     *
     */
    public void runTimer() {
        timer.start();
    }
}
