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
 * The first screen a player sees. Contains a text field for the player name,
 * option to cheat (TBA), and high scores (TBA).
 */
public class StartScene extends BaseScene {

    public StartScene(SceneManager manager, GameLogic logic) {
        super(manager, logic);
    }

    /**
     * Creates the elements for the scene.
     */
    public void buildScene() {
        layout = new GridPane();
        GridPane gridLayout = (GridPane) layout;

        gridLayout.setPrefSize(600, 400);
        gridLayout.getColumnConstraints().add(new ColumnConstraints(160));
        gridLayout.getColumnConstraints().add(new ColumnConstraints(280));
        gridLayout.getColumnConstraints().add(new ColumnConstraints(160));
        gridLayout.getRowConstraints().add(new RowConstraints(50));
        gridLayout.getRowConstraints().add(new RowConstraints(220));
        gridLayout.getRowConstraints().add(new RowConstraints(130));

        Text title = new Text("Podship");
        title.setFont(Font.font(STYLESHEET_CASPIAN, 60));

        gridLayout.add(title, 1, 1);

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

        gridLayout.add(debug, 0, 2);
        gridLayout.add(gamestart, 1, 2);
        gridLayout.add(hiscore, 2, 2);

        scene = new Scene(gridLayout);

        launchButton.setOnAction(e -> {
            logic.newGame(nameField.getText(),
                    new int[]{5, 5, 5, 5, 5, 5, 5});
            manager.setScene("turn");
        });

        quitButton.setOnAction(e -> Platform.exit());

    }

}
