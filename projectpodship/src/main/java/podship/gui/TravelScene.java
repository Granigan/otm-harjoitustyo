package podship.gui;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import podship.logic.GameLogic;

/**
 * The main interaction screen, for the turn phase. Allows player to see event
 * descriptions and make a choice by clicking the corresponding option button.
 * After each
 */
public class TravelScene extends BaseScene {

    private TextArea log;
    private int counter = 0;
    private int cap = 30; // set to ~200 in final
    private AnimationTimer timer;

    public TravelScene(SceneManager manager, GameLogic logic) {
        super(manager, logic);
    }

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
        log.setPrefSize(600, 340);
        log.setLayoutX(0);
        log.wrapTextProperty().set(true);

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

        layout.getChildren().addAll(menuButton, exitButton, log);
        scene = new Scene(layout);

        menuButton.setOnAction(e -> manager.setScene("start"));
        exitButton.setOnAction(e -> Platform.exit());

    }

    public void addLogEntry(String entry) {
        log.appendText(entry);
    }

    public void runTimer() {
        timer.start();
    }
}
