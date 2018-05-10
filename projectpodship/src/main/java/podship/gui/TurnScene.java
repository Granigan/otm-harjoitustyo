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
        Button chooseFirst = new Button("Choose first option");
        Button chooseSecond = new Button("Choose second option");
        Button chooseThird = new Button("Choose third option");
        
        buttonSetup(chooseFirst);
        buttonSetup(chooseSecond);
        buttonSetup(chooseThird);
        
        chooseFirst.setLayoutX(201);
        chooseSecond.setLayoutX(334);
        chooseThird.setLayoutX(467);

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
    
    public void buttonSetup(Button b) {
        b.setPrefSize(133, 100);
        b.setLayoutY(300);
        b.wrapTextProperty().set(true);
    }
}
