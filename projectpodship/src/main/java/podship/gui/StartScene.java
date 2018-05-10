package podship.gui;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import podship.logic.GameLogic;

/**
 *
 */
public class StartScene {

    private GridPane layout;
    private Scene scene;
    private SceneManager manager;
    private GameLogic logic;

    public StartScene(SceneManager manager, GameLogic logic) {
        this.manager = manager;
        this.logic = logic;
        layout = new GridPane();
    }

    public Scene getScene() {
        layout = new GridPane();
        scene = null;
        buildScene();
        return scene;
    }

    public void buildScene() {
        layout.setPrefSize(600, 400);
        layout.getColumnConstraints().add(new ColumnConstraints(160));
        layout.getColumnConstraints().add(new ColumnConstraints(280));
        layout.getColumnConstraints().add(new ColumnConstraints(160));
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getRowConstraints().add(new RowConstraints(220));
        layout.getRowConstraints().add(new RowConstraints(130));

        Text title = new Text("Podship");
        title.setFont(Font.font(STYLESHEET_CASPIAN, 60));

        layout.add(title, 1, 1);

        VBox debug = new VBox();
        debug.setPrefSize(200, 0);
        Text debugMenuTitle = new Text("Debug / Settings");
        debug.getChildren().add(debugMenuTitle);

        VBox gamestart = new VBox();
        gamestart.setPrefSize(200, 0);
        Text nameRequestText = new Text("What is your name, Director?");
        TextField nameField = new TextField();

        HBox buttons = new HBox();
        Button launchButton = new Button("LAUNCH");
        Button quitButton = new Button("QUIT");
        buttons.getChildren().add(launchButton);
        buttons.getChildren().add(quitButton);

        gamestart.getChildren().add(nameRequestText);
        gamestart.getChildren().add(nameField);
        gamestart.getChildren().add(buttons);

        VBox hiscore = new VBox();
        hiscore.setPrefSize(200, 0);
        Text topScoresTitle = new Text("Top directors:");
        hiscore.getChildren().add(topScoresTitle);

        layout.add(debug, 0, 2);
        layout.add(gamestart, 1, 2);
        layout.add(hiscore, 2, 2);

        scene = new Scene(layout);

        launchButton.setOnAction(e -> {
            logic.newGame(nameField.getText(),
                    new int[]{0, 0, 0, 0, 0, 0, 0});
            manager.setScene("turn");
        });

        quitButton.setOnAction(e -> Platform.exit());

    }

}
