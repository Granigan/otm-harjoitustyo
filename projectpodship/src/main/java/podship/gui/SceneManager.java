package podship.gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Methods for initialisíng and switching scenes.
 */
public class SceneManager {

    private Stage window;
    private StartScene start;
    private TravelScene travel;
    private TurnScene turn;

    /**
     * Constructor that initialises the three scenes and links Stage, SceneManager
     * and Scenes.
     * @param window 
     */
    public SceneManager(Stage window) {
        this.window = window;
        start = new StartScene(this);
        travel = new TravelScene(this);
        turn = new TurnScene(this);

    }

    /**
     * Switches the scene to the one defined by the parameter.
     * @param sceneName accepts "start", "travel", or "turn" as string
     */
    public void setScene(String sceneName) {
        Scene nextScene;

        switch (sceneName) {
            default:
                nextScene = start.getScene();
                break;
            case "start":
                nextScene = start.getScene();
                break;
            case "travel":
                nextScene = travel.getScene();
                break;
            case "turn":
                nextScene = turn.getScene();
                break;
        }

        window.setScene(nextScene);
        window.show();
    }

}
