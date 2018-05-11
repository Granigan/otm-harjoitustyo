package podship.logic;

import java.util.*;
import podship.daos.*;
import podship.events.*;
import podship.travel.*;

/**
 * Contains methods for the pre-launch stage.
 *
 * @author tgtapio
 */
public class TurnLogic {

    private EventDeck eventDeck;
    private EventDao eventDao;
    private TravelStats stats;
    private int turnCount;
    private String name;
    private List<Integer> travelEventIDs;

    /**
     * Default constructor used for testing.
     */
    public TurnLogic() {
        eventDeck = new EventDeck();
        // INIT from mockDAO, later from DB
        eventDao = new EventDao();
        travelEventIDs = new ArrayList<>();
        for (BuildEvent e : eventDao.getTurnEventsDB()) {
            eventDeck.addEvent(e);
        }
        turnCount = eventDeck.getDeckSize() - 3; // during debug, turns == events-3
        stats = new TravelStats();
        name = "";

    }

    /**
     * Constructor initialises the pre-launch stage
     */
    public TurnLogic(TravelStats stats) {
        eventDeck = new EventDeck();
        // INIT from mockDAO, later from DB
        eventDao = new EventDao();
        travelEventIDs = new ArrayList<>();
        for (BuildEvent e : eventDao.getTurnEventsDB()) {
            eventDeck.addEvent(e);
        }
        turnCount = eventDeck.getDeckSize() - 3; // during debug, turns == events-3
        this.stats = stats;
        name = this.stats.getDirectorName();
    }

    /**
     * Contains the intro text
     *
     * @return Returns intro text as a string.
     */
    public String getIntroText() {
        return "Welcome, director " + name + "."
                + "You've been tasked with overseeing the Project Podship.\n\n"
                + "In short, Earth is facing an existential crisis, and no one knows for sure if "
                + "we'll survive. To ensure humanity will not perish with the planet, we'll need to "
                + "colonise elsewhere. Unfortunately, our colonies in Mars and Ganymede "
                + "will still be reliant on Earth for decades to come, and thus, we must look elsewhere.\n\n"
                + "You'll oversee the construction of Podship, destined for Gliese 832.\n\n"
                + "That's 16.16 light years away.\n\n"
                + "That means the population of the ship will "
                + "not be passengers, but rather, they'll move to the ship to live and die there. "
                + "Dozens of the next generations will be born and will die inside the ship, "
                + "while it travels.\n\n"
                + "I'm sure you understand the enormity of the task. But you must succeed.\n\n"
                + "Good luck, director " + name;
    }

    /**
     * Gives the mock options for the first/intro event.
     * @return list of Options
     */
    public ArrayList<Option> getIntroOptions() {
        ArrayList<Option> options = new ArrayList<>();
        options.add(new Option("I understand"));
        options.add(new Option("I will not fail!"));
        options.add(new Option("Let's get started."));
        return options;
    }

    /**
     * Compiles the first/intro event, putting together the text and options
     * 
     * @return the first/intro event
     */
    public BuildEvent getFirstEvent() {
        return new BuildEvent(getIntroText(), getIntroOptions());
    }

    /**
     * The final/launch event, telling player to launch the ship.
     * 
     * @return the final/launch Event
     */
    public BuildEvent getLaunchEvent() {
        String launchText = "Time has ran out, director. We must launch the ship "
                + "now and hope for the best.\n\n"
                + "Say your prayers and complete any last rites, and when you're "
                + "ready, launch the ship.\n\n"
                + "Good luck to us all!";
        ArrayList<Option> options = new ArrayList<>();
        options.add(new Option("Launch the ship"));
        options.add(new Option("IGNITE!"));
        options.add(new Option("3... 2... 1... Lift-off!"));
        return new BuildEvent(launchText, options);
    }

    /**
     * Includes a check for turns remaining.
     *
     * @return Returns true if time has ran out. Otherwise returns false.
     */
    public boolean checkForLaunch() {
        if (turnCount == 0) {
            return true;
        }
        return false;
    }

    /**
     * Fetches the next event from the EventDeck
     * 
     * @return the next Event given by EventDeck
     */
    public BuildEvent getNextEvent() {
        BuildEvent be = (BuildEvent) eventDeck.getNextEvent();
        return be;
    }

    /**
     * Setter for int turnCount, shows how many turns are left before mandatory
     * launch.
     *
     * @param turnCount new value for turnCount
     */
    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    /**
     * Setter for string Name, i.e. captains name.
     *
     * @param name new value for name
     */
    public void setName(String name) {
        this.name = name;
    }

}
