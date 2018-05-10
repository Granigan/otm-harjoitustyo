package podship.gui;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import podship.logic.GameLogic;

/**
 *
 */
public class TravelScene {

    private Pane layout;
    private Scene scene;
    private SceneManager manager;
    private GameLogic logic;
    private TextArea log;

    public TravelScene(SceneManager manager, GameLogic logic) {
        this.layout = new Pane();
        this.logic = logic;
        this.manager = manager;
        this.logic = logic;
    }

    public Scene getScene() {
        layout = new Pane();
        scene = null;
        buildScene();

        return scene;
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
        
        long prevNanos = 0;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (prevNanos == 0) {
                    prevNanos = now;
                    return;
                }
                long deltaNanos = now - prevNanos;
                prevNanos = now;
                
            }
        }

        layout.getChildren().addAll(menuButton, exitButton, log);
        scene = new Scene(layout);

        menuButton.setOnAction(e -> manager.setScene("start"));
        exitButton.setOnAction(e -> Platform.exit());

    }

    public void addLogEntry(String entry) {
        log.setText(log.getText() + entry);
    }
}
