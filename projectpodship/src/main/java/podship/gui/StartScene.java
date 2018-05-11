package podship.gui;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
 * option to cheat (TBA), high scores (TBA), buttons to start and quit.
 */
public class StartScene extends BaseScene {

    private VBox debug;
    private TextField air;
    private TextField energy;
    private TextField faith;
    private TextField food;
    private TextField morale;
    private TextField population;
    private TextField water;

    public StartScene(SceneManager manager, GameLogic logic) {
        super(manager, logic);
        air = new TextField("0");
        energy = new TextField("0");
        faith = new TextField("0");
        food = new TextField("0");
        morale = new TextField("0");
        population = new TextField("0");
        water = new TextField("0");
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
        gridLayout.setGridLinesVisible(true);

        debug = new VBox();
        debug.setPrefSize(200, 0);
        Text debugMenuTitle = new Text("Debug / Cheat");

        debug.getChildren().add(debugMenuTitle);
        statSelection();

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

        gridLayout.add(debug, 0, 1);
        gridLayout.add(gamestart, 1, 2);
        gridLayout.add(hiscore, 2, 2);

        scene = new Scene(gridLayout);

        launchButton.setOnAction(e -> {
            logic.newGame(nameField.getText(),
                    new int[]{Integer.parseInt(air.getText()),
                        Integer.parseInt(energy.getText()),
                        Integer.parseInt(faith.getText()),
                        Integer.parseInt(food.getText()),
                        Integer.parseInt(morale.getText()),
                        Integer.parseInt(population.getText()),
                        Integer.parseInt(water.getText()),
                        });
            manager.setScene("turn");
        });

        quitButton.setOnAction(e -> Platform.exit());

    }

    public void statSelection() {
        HBox airLine = new HBox();
        airLine.getChildren().addAll(new Text("Air: "), formatInput(air));

        HBox energyLine = new HBox();
        energyLine.getChildren().addAll(new Text("Energy: "), formatInput(energy));

        HBox faithLine = new HBox();
        faithLine.getChildren().addAll(new Text("Faith: "), formatInput(faith));

        HBox foodLine = new HBox();
        foodLine.getChildren().addAll(new Text("Food: "), formatInput(food));

        HBox moraleLine = new HBox();
        moraleLine.getChildren().addAll(new Text("Morale: "), formatInput(morale));

        HBox populationLine = new HBox();
        populationLine.getChildren().addAll(new Text("Population: "), formatInput(population));

        HBox waterLine = new HBox();
        waterLine.getChildren().addAll(new Text("Water: "), formatInput(water));

        debug.getChildren().addAll(airLine, energyLine, faithLine, foodLine,
                moraleLine, populationLine, waterLine);
    }

    public TextField formatInput(TextField tf) {
        tf.setText("0");
        tf.setPrefWidth(25);
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        return tf;
    }

}
