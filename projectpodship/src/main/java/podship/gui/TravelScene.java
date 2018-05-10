package podship.gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 */
public class TravelScene {

    private Pane layout;
    private Scene scene;
    private SceneManager manager;

    public TravelScene(SceneManager manager) {
        this.layout = new Pane();
        this.manager = manager;
    }

    public Scene getScene() {
        if (scene == null) {
            buildScene();
        }
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

        layout.getChildren().addAll(menuButton, exitButton);
        scene = new Scene(layout);

        menuButton.setOnAction(e -> manager.setScene("start"));
        exitButton.setOnAction(e -> Platform.exit());

    }
}
