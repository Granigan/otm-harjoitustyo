package podship.domain;

//public class Main {

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
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
        GridPane layout = new GridPane();
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

        Scene start = new Scene(layout);

        window.setScene(start);
        window.show();
        
        launchButton.setOnAction(event -> {
            GameLauncher launcher = new GameLauncher(nameField.getText(), 
                    new int[]{0, 0, 0, 0, 0, 0, 0});
            launcher.runGame();
        });

    }
    
    public static void main(String[] args) {
        launch(Main.class);
    }
}
