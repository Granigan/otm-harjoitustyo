package podship.gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 */
public class TurnScene {

    private Pane layout;
    private Scene scene;
    private SceneManager manager;

    public TurnScene(SceneManager manager) {
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
        Button chooseFirst = optionButtonSetup("Choose first option", 201);
        Button chooseSecond = optionButtonSetup("Choose second option", 334);
        Button chooseThird = optionButtonSetup("Choose Third option", 467);

        Button menuButton = new Button("Leave Game");
        Button exitButton = new Button("Exit Program");

        menuButton.setLayoutX(0);
        menuButton.setLayoutY(350);
        menuButton.setPrefSize(100, 50);

        exitButton.setLayoutX(100);
        exitButton.setLayoutY(350);
        exitButton.setPrefSize(100, 50);
        exitButton.wrapTextProperty().set(true);

        layout.getChildren().addAll(chooseFirst, chooseSecond, chooseThird, menuButton, exitButton);
        scene = new Scene(layout);

        chooseFirst.setOnAction(e -> chooseThird.setText("LAUNCH SHIP"));
        chooseThird.setOnAction(e -> {
            chooseThird.setText("Choose third option");
            manager.setScene("travel");
        });
        exitButton.setOnAction(e -> Platform.exit());

    }
    
    public Button optionButtonSetup(String text, int x) {
        Button b = new Button(text);
        b.setPrefSize(133, 100);
        b.setLayoutX(x);
        b.setLayoutY(300);
        b.wrapTextProperty().set(true);
        return b;
    }
}
