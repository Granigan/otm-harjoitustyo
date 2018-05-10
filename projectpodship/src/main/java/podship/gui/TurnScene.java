package podship.gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import podship.logic.GameLogic;

/**
 *
 */
public class TurnScene {

    private Pane layout;
    private Scene scene;
    private SceneManager manager;
    private GameLogic logic;

    public TurnScene(SceneManager manager, GameLogic logic) {
        this.layout = new Pane();
        this.logic = logic;
        this.manager = manager;
        this.logic = logic;
    }

    public Scene getScene() {
        if (scene == null) {
            buildScene();
        }
        return scene;
    }

    public void buildScene() {
        Button chooseFirst = optionButtonSetup("I understand.", 201, "1");
        Button chooseSecond = optionButtonSetup("Let's get started.", 334, "2");
        Button chooseThird = optionButtonSetup("I will not fail!", 467, "3");

        Button menuButton = new Button("Leave Game");
        Button exitButton = new Button("Exit");

        menuButton.setLayoutX(100);
        menuButton.setLayoutY(350);
        menuButton.setPrefSize(100, 50);

        exitButton.setLayoutX(0);
        exitButton.setLayoutY(350);
        exitButton.setPrefSize(100, 50);

        TextArea eventScreen = new TextArea();
        eventScreen.setLayoutX(200);
        eventScreen.setLayoutY(0);
        eventScreen.setPrefSize(400, 300);
        eventScreen.wrapTextProperty().set(true);
        eventScreen.setText(logic.getTurnLogic().getIntroText());

        layout.getChildren().addAll(chooseFirst, chooseSecond, chooseThird,
                menuButton, exitButton,
                eventScreen);
        scene = new Scene(layout);

        chooseFirst.setOnAction(e -> chooseThird.setText("LAUNCH SHIP"));
        chooseThird.setOnAction(e -> {
            chooseThird.setText("It's about time!");
            manager.setScene("travel");
        });
        exitButton.setOnAction(e -> Platform.exit());

    }

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
    
    public void optionChosen(int id) {
        logic.getTurnLogic().selectionMade(id);
    }
    

}
