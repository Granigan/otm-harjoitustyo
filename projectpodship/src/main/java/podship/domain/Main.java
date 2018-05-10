package podship.domain;

//public class Main {
import java.awt.Insets;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import podship.logic.GameLauncher;

//
//    static final String API_KEY = "AIzaSyBQJlsAOCms7A0FAamp6nHOrPuWsVvIY_M";
//
//    public static void main(String[] args) {
//        
//
//
// RUN THE TEXT BASED WITH THESE
//        TurnLogic turnLogic = new TurnLogic();
//        turnLogic.newGame();
//        TravelLogic travelLogic = turnLogic.launchShip();
//        travelLogic.travel();
//    }
//}
public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception {

        // START SCENE
        GridPane startLayout = new GridPane();
        startLayout.setPrefSize(600, 400);
        startLayout.getColumnConstraints().add(new ColumnConstraints(160));
        startLayout.getColumnConstraints().add(new ColumnConstraints(280));
        startLayout.getColumnConstraints().add(new ColumnConstraints(160));
        startLayout.getRowConstraints().add(new RowConstraints(50));
        startLayout.getRowConstraints().add(new RowConstraints(220));
        startLayout.getRowConstraints().add(new RowConstraints(130));

        Text title = new Text("Podship");
        title.setFont(Font.font(STYLESHEET_CASPIAN, 60));

        startLayout.add(title, 1, 1);

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

        startLayout.add(debug, 0, 2);
        startLayout.add(gamestart, 1, 2);
        startLayout.add(hiscore, 2, 2);

        Scene start = new Scene(startLayout);

        // END OF START SCENE
        // TURN SCENE
        Pane turnLayout = new Pane();
        turnLayout.setMinSize(600, 400);

        // Option buttons
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

        // Menu and Quit buttons
        Button menu = new Button("Leave Game");
        Button quit = new Button("Exit Program");

        menu.setLayoutX(0);
        menu.setLayoutY(350);
        menu.setPrefSize(100, 50);

        quit.setLayoutX(100);
        quit.setLayoutY(350);
        quit.setPrefSize(100, 50);
        quit.wrapTextProperty().set(true);

        // Finishing touches
        turnLayout.getChildren().addAll(chooseFirst, chooseSecond, chooseThird, menu, quit);
        Scene turn = new Scene(turnLayout);

        // END OF TURN SCENE
        // TRAVEL SCENE
        Pane travelLayout = new Pane();
        Button exitButton = new Button("Exit Program");
        Button menuButton = new Button("Back to Menu");

        menuButton.setPrefSize(350, 30);
        exitButton.setPrefSize(50, 30);

        menuButton.setLayoutX(90);
        menuButton.setLayoutY(360);

        exitButton.setLayoutX(500);
        exitButton.setLayoutY(360);

        travelLayout.getChildren().addAll(menuButton, exitButton);
        Scene travel = new Scene(travelLayout);
        // END OF TRAVEL SCENE

        launchButton.setOnAction(e -> {
            GameLauncher launcher = new GameLauncher(nameField.getText(),
                    new int[]{0, 0, 0, 0, 0, 0, 0});
            window.setScene(turn);
//            launcher.runGame();
        });

        quitButton.setOnAction(e -> Platform.exit());

        chooseFirst.setOnAction(e -> chooseThird.setText("LAUNCH SHIP"));
        chooseThird.setOnAction(e -> {
            chooseThird.setText("Choose third option");
            window.setScene(travel);
        });
        quit.setOnAction(e -> Platform.exit());

        menuButton.setOnAction(e -> window.setScene(start));
        exitButton.setOnAction(e -> Platform.exit());

        window.setScene(travel);
        window.show();

    }

//    public turnOptionButtonConfig(Button b) {
//        b.setPrefSize(133, 100);
//        b.setLayoutY(300);
//        b.wrapTextProperty().set(true);
//    }
    public static void main(String[] args) {
        launch(Main.class);
    }
}
