package podship.logic;

import java.util.ArrayList;
import java.util.Random;
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
    private TravelLogic travelLogic;
    private Event currentEvent;
    private TurnScene turnScene;
    private TravelScene travelScene;
    private StartScene startScene;
    private ArrayList<Integer> unlockIDs;
    private int year;
    private Random r;

    public GameLogic() {
        unlockIDs = new ArrayList<>();
        year = 2178;
        r = new Random();
    }

    // Build phase begins
    public void newGame(String name, int[] stats) {
        this.stats = new TravelStats(name, stats);
        turnLogic = new TurnLogic(this.stats);
        currentEvent = turnLogic.getFirstEvent();
    }

    public void selectionMade(int id) {
        BuildEvent be = (BuildEvent) currentEvent;
        Option chosenOption = be.getOptions().get(id);
        stats.adjustResources(chosenOption.getStatAdjustments());
        for (int i : chosenOption.getUnlocks()) {
            unlockIDs.add(i);
        }

        turnLogic.setTurnCount(turnLogic.getTurnCount() - 1);
        if (!turnLogic.checkForLaunch()) {
            currentEvent = turnLogic.getNextEvent();
            updateBuildEventTexts();
        } else {
            processLaunch();
        }
    }

    public void updateBuildEventTexts() {
        BuildEvent be = (BuildEvent) currentEvent;
        turnScene.setEventTexts(be.getOptions().get(0).getDesc(),
                be.getOptions().get(1).getDesc(),
                be.getOptions().get(2).getDesc(), be.getDesc());
    }

    public void processLaunch() {
        currentEvent = (BuildEvent) turnLogic.getLaunchEvent();
        updateBuildEventTexts();
        turnScene.initiateLaunch();

    }

    // Travel phase begins
    public void beginVoyage() {
        travelLogic = new TravelLogic(stats, unlockIDs);
        travelScene.addLogEntry(formatEntry(travelLogic.getLaunchText()));

        travel();
    }

    public void travel() {
        if (!stats.hasAllResources()) {
            travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()));
        } else {
            year += 30 + r.nextInt(50);
            travelScene.addLogEntry(formatEntry(travelLogic.proceedJourney()));
            if (travelLogic.getDistance() < 1) {
                travelScene.addLogEntry(formatFinalEntry(travelLogic.getArrivalText()));
            } else if (!stats.hasAllResources()) {
                travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()));
            } else {
                travelScene.runTimer();

            }
        }

    }

    //BACKUP BELOW
//    public void travel() {
//        if (!stats.hasAllResources()) {
//            travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()));
//        }
//        while (stats.hasAllResources()) {
//            year += 30 + r.nextInt(50);
//            travelScene.addLogEntry(formatEntry(travelLogic.proceedJourney()));
//            if (travelLogic.getDistance() < 1) {
//                travelScene.addLogEntry(formatFinalEntry(travelLogic.getArrivalText()));
//                break;
//            }
//            if (!stats.hasAllResources()) {
//                travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()));
//            }
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
//        }
//
//    }
    public String formatEntry(String entry) {
        return "" + year + ": " + entry + "\n\n"
                + travelLogic.getDistance() + " turns until arrival.\n\n\n";
    }

    public String formatFinalEntry(String entry) {
        return "" + year + ": " + entry;
    }

    // getters, setters, etc
    public TravelStats getStats() {
        return stats;
    }

    public TurnLogic getTurnLogic() {
        return turnLogic;
    }

    public void setTurnScene(TurnScene turnScene) {
        this.turnScene = turnScene;
    }

    public void setTravelScene(TravelScene travelScene) {
        this.travelScene = travelScene;
    }

}
