package podship.domain;

import javafx.application.Application;
import javafx.stage.Stage;
import podship.gui.SceneManager;
import podship.logic.GameLogic;

/**
 * Launches the app via the SceneManager
 *
 * @author tgtapio
 */
public class Main extends Application {

    private SceneManager manager;
    private GameLogic logic;

    @Override
    public void start(Stage window) {
        logic = new GameLogic();
        manager = new SceneManager(window, logic);
        manager.setScene("start");
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
