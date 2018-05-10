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

        Button[] optionButtons = new Button[3];

        chooseFirst.setPrefSize(133, 100);
        chooseSecond.setPrefSize(133, 100);
        chooseThird.setPrefSize(133, 100);
        chooseFirst.setLayoutY(300);
        chooseSecond.setLayoutY(300);
        chooseThird.setLayoutY(300);
        chooseFirst.wrapTextProperty().set(true);
        chooseSecond.wrapTextProperty().set(true);
        chooseThird.wrapTextProperty().set(true);

        chooseFirst.setLayoutX(201);
        chooseSecond.setLayoutX(334);
        chooseThird.setLayoutX(467);

        Button menu = new Button("Leave Game");
        Button quit = new Button("Exit Program");

        menu.setLayoutX(0);
        menu.setLayoutY(350);
        menu.setPrefSize(100, 50);

        quit.setLayoutX(100);
        quit.setLayoutY(350);
        quit.setPrefSize(100, 50);
        quit.wrapTextProperty().set(true);

        layout.getChildren().addAll(chooseFirst, chooseSecond, chooseThird, menu, quit);
        scene = new Scene(layout);

        chooseFirst.setOnAction(e -> chooseThird.setText("LAUNCH SHIP"));
        chooseThird.setOnAction(e -> {
            chooseThird.setText("Choose third option");
            manager.setScene("travel");
        });
        quit.setOnAction(e -> Platform.exit());

    }
}
