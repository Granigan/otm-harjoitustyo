package podship.gui;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage window) throws Exception {
        GridPane layout = new GridPane();
        layout.setPrefSize(600, 400);

        layout.setGridLinesVisible(true); //DEBUG

        Text title = new Text("Podship");
        title.setFont(Font.font(STYLESHEET_CASPIAN, 60));

        layout.add(title, 1, 0);

        VBox left = new VBox();
        Text debugMenuTitle = new Text("Debug / Settings");
        left.getChildren().add(debugMenuTitle);

        VBox mid = new VBox();
        Text nameRequestText = new Text("What is your name, Director?");
        TextField nameField = new TextField();
        Button launchButton = new Button("LAUNCH");
        Button quitButton = new Button("QUIT");

        mid.getChildren().add(nameRequestText);
        mid.getChildren().add(nameField);
        mid.getChildren().add(launchButton);
        mid.getChildren().add(quitButton);

        VBox right = new VBox();
        Text topScoresTitle = new Text("Top directors:");
        right.getChildren().add(topScoresTitle);

        layout.add(left, 0, 1);
        layout.add(mid, 1, 1);
        layout.add(right, 2, 1);

        Scene start = new Scene(layout);

        window.setScene(start);
        window.show();

    }
    
    public static void main(String[] args) {
        launch(UI.class);
    }
}
