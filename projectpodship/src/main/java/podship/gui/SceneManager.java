package podship.gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import podship.logic.GameLogic;

/**
 * Methods for initialisíng and switching scenes.
 */
public class SceneManager {

    private Stage window;
    private StartScene start;
    private TravelScene travel;
    private TurnScene turn;
    private GameLogic logic;

    /**
     * Constructor that initialises the three scenes and links Stage,
     * SceneManager and Scenes.
     *
     * @param window
     */
    public SceneManager(Stage window, GameLogic logic) {
        this.window = window;
        this.window.setResizable(false);
        this.window.setTitle("Podship");
        this.logic = logic;
        start = new StartScene(this, logic);
        travel = new TravelScene(this, logic);
        turn = new TurnScene(this, logic);

    }

    /**
     * Switches the scene to the one defined by the parameter.
     *
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
                logic.setTravelScene(travel);
                nextScene = travel.getScene();
                break;
            case "turn":
                logic.setTurnScene(turn);
                nextScene = turn.getScene();
                break;
        }

        window.setScene(nextScene);
        window.show();
    }

}
