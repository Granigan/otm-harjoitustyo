package podship.domain;

import javafx.application.Application;
import javafx.stage.Stage;
import podship.gui.SceneManager;

//    static final String API_KEY = "AIzaSyBQJlsAOCms7A0FAamp6nHOrPuWsVvIY_M";
//
//    public static void main(String[] args) {
//      // RUN THE TEXT BASED WITH THESE
//        TurnLogic turnLogic = new TurnLogic();
//        turnLogic.newGame();
//        TravelLogic travelLogic = turnLogic.launchShip();
//        travelLogic.travel();
//    }
//}
public class Main extends Application {

    private SceneManager manager;

    @Override
    public void start(Stage window) {
        manager = new SceneManager(window);
        manager.setScene("start");
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
