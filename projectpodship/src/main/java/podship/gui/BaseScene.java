package podship.gui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import podship.logic.GameLogic;

/**
 * Superclass for scenes.
 *
 * @author tgtapio
 */
public abstract class BaseScene {

    protected Pane layout;
    protected Scene scene;
    protected SceneManager manager;
    protected GameLogic logic;

    /**
     * Constructor, links the StartScene with logic and scene manager.
     * Initialises grid pane.
     *
     * @param manager links the scene to other scenes.
     * @param logic links the scene with logic.
     */
    public BaseScene(SceneManager manager, GameLogic logic) {
        this.manager = manager;
        this.logic = logic;
        layout = new Pane();
    }

    /**
     * Returns the freshly created scene for the scene manager. Creating scenes
     * anew allows replaying without restarting.
     *
     * @return Scene for the SceneManager
     */
    public Scene getScene() {
        scene = null;
        layout = new Pane();
        buildScene();
        return scene;
    }

    /**
     * Creates the elements for the scene.
     */
    public abstract void buildScene();
}
