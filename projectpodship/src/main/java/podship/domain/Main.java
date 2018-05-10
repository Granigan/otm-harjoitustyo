package podship.domain;

import javafx.application.Application;
import javafx.stage.Stage;
import podship.gui.SceneManager;

//    public static void main(String[] args) {
//      // RUN THE TEXT BASED WITH THESE
//        TurnLogic turnLogic = new TurnLogic();
//        turnLogic.newGame();
//        TravelLogic travelLogic = turnLogic.launchShip();
//        travelLogic.travel();
//    }
//}

/**
 * Launches the app via the SceneManager
 * @author tgtapio
 */
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
