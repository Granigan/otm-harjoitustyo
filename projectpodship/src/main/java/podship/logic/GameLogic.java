package podship.logic;

import java.util.ArrayList;
import java.util.Random;
import podship.daos.HighScoreDao;
import podship.events.BuildEvent;
import podship.events.Event;
import podship.events.Option;
import podship.gui.TravelScene;
import podship.gui.TurnScene;
import podship.travel.TravelStats;

/**
 * Runs the game logic and connects GUI with other logic. Engine for the game.
 */
public class GameLogic {

    private TravelStats stats;
    private TurnLogic turnLogic;
    private TravelLogic travelLogic;
    private Event currentEvent;
    private TurnScene turnScene;
    private TravelScene travelScene;
    private ArrayList<Integer> unlockIDs;
    private HighScoreDao hiScoreDao;
    private int year;
    private Random r;

    /**
     * Default constructor run at the very start. Ran only once per app launch.
     */
    public GameLogic() {
        r = new Random();
        hiScoreDao = new HighScoreDao();
    }

    /**
     * Effective constructor, initialises a new game by resetting the year,
     * unlockIDs, and creates new TurnLogic and TravelStats.
     *
     * @param name player/director name
     * @param stats starting stats set in the start screen (support TBA)
     */
    public void newGame(String name, int[] stats) {
        unlockIDs = new ArrayList<>();
        year = 2178;
        this.stats = new TravelStats(name, stats);
        turnLogic = new TurnLogic(name);
        currentEvent = turnLogic.getFirstEvent();
    }

    /**
     * Processes the turn, ie. handles the chosen Option, reduces turn count,
     * checks if ship must launch, and either sets up a new event, or calls the
     * launch process.
     *
     * Effects of the chosen Option: modifies ship stats and adds possible
     * unlock IDs to the unlockID listTests run: 3, Failures: 0, Errors: 1,
     * Skipped: 0, Time elapsed: 0.027 sec <<< FAILURE!
     *
     * @param id tells which Option was chosen
     */
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

    /**
     * Calls for the event and option texts in the TurnScene to be updated to
     * match the currentEvent.
     *
     */
    public void updateBuildEventTexts() {
        BuildEvent be = (BuildEvent) currentEvent;
        turnScene.setEventTexts(be.getOptions().get(0).getDesc(),
                be.getOptions().get(1).getDesc(), be.getOptions().get(2).getDesc(), 
                be.getDesc());
    }

    /**
     * Gets the launch event and calls the TurnScene to update event and option
     * texts with the launch event info, forcing the player to launch the ship.
     */
    public void processLaunch() {
        currentEvent = (BuildEvent) turnLogic.getLaunchEvent();
        updateBuildEventTexts();
        turnScene.initiateLaunch();
    }

    /*
    *                 TRAVEL PHASE BEGINS
     */
    /**
     * Creates the TravelLogic with the TravelStats and unlockIDs list. Sends
     * the first log message (launch) to TravelLogic and begins the travel() -
     * runTimer() cycle.
     */
    public void beginVoyage() {
        travelLogic = new TravelLogic(stats, unlockIDs);
        travelScene.addLogEntry(formatEntry(travelLogic.getLaunchText()), stats.toString());

        travel();
    }

    /**
     * Half of the travel-timer cycle that runs the travel/final phase.
     *
     * Checks if ship has at least 1 of each resource before and after the
     * travel event, adds years to the count, and sends an appropriate log entry
     * to TurnScene.
     *
     * Finally, while travel continues, calls runTimer() in TurnScene, which in
     * turn calls back travel after a brief delay.
     */
    public void travel() {
        String s = stats.toString();
        if (!stats.hasAllResources()) {
            hiScoreDao.newEntry(stats.getDirectorName(), stats.countScore());
            travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()), s);
        } else {
            year += 30 + r.nextInt(50);
            travelScene.addLogEntry(formatEntry(travelLogic.proceedJourney()), s);
            if (travelLogic.getDistance() < 1) {
                travelScene.addLogEntry(formatFinalEntry(travelLogic.getArrivalText()), s);
                hiScoreDao.newEntry(stats.getDirectorName(), 100 + stats.countScore());
            } else if (!stats.hasAllResources()) {
                travelScene.addLogEntry(formatFinalEntry(travelLogic.getFailureText()), s);
                hiScoreDao.newEntry(stats.getDirectorName(), stats.countScore());
            } else {
                travelScene.runTimer();
            }
        }
    }

    /**
     * Help method for formatting the log entry, adding year and number of
     * remaining turns to it. Used with travel events.
     *
     * @param entry raw log entry
     * @return year + entry + turns left
     */
    public String formatEntry(String entry) {
        return "" + year + ": " + entry + "\n\n"
                + travelLogic.getDistance() + " turns until arrival.\n\n\n";
    }

    /**
     * Help method for formatting the final log entry, whether it's a success or
     * failure.
     *
     * @param entry raw log entry
     * @return year + result
     */
    public String formatFinalEntry(String entry) {
        return "" + year + ": " + entry;
    }

    /*
    *                  getters, setters, etc
     */
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

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public HighScoreDao getHiScoreDao() {
        return hiScoreDao;
    }

}