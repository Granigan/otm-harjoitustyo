package podship.logic;

import java.util.ArrayList;
import podship.events.BuildEvent;
import podship.events.Event;
import podship.events.Option;
import podship.gui.StartScene;
import podship.gui.TravelScene;
import podship.gui.TurnScene;
import podship.travel.TravelStats;

/**
 * Creates the classes for a new game and launches it
 */
public class GameLogic {

    private TravelStats stats;
    private TurnLogic turnLogic;
    private Event currentEvent;
    private TurnScene turnScene;
    private TravelScene travelScene;
    private StartScene startScene;

    public GameLogic() {
    }

    public void newGame(String name, int[] stats) {
        this.stats = new TravelStats(name, stats);
        turnLogic = new TurnLogic(this.stats);
        currentEvent = turnLogic.getFirstEvent();
    }

    public void updateBuildEventTexts() {
        BuildEvent be = (BuildEvent) currentEvent;
        turnScene.setEventTexts(be.getOptions().get(0).getDesc(),
                be.getOptions().get(1).getDesc(),
                be.getOptions().get(2).getDesc(), be.getDesc());
    }

    public void selectionMade(int id) {
        BuildEvent be = (BuildEvent) currentEvent;
        stats.adjustResources(be.getOptions().get(id).getStatAdjustments());
        turnLogic.setTurnCount(turnLogic.getTurnCount() - 1);
        if (!turnLogic.checkForLaunch()) {
            currentEvent = turnLogic.getNextEvent();
            updateBuildEventTexts();
        } else {
            processLaunch();
        }
    }

    public void processLaunch() {
        currentEvent = (BuildEvent) turnLogic.getLaunchEvent();
        updateBuildEventTexts();
        turnScene.initiateLaunch();
    }

    public TravelStats getStats() {
        return stats;
    }

    public TurnLogic getTurnLogic() {
        return turnLogic;
    }

    public void runGame() {
        turnLogic.newGame();
        TravelLogic travelLogic = turnLogic.launchShip();
        travelLogic.travel();
    }

    public void setTurnScene(TurnScene turnScene) {
        this.turnScene = turnScene;
    }

}
