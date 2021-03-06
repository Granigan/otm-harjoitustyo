package podship.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import podship.events.TravelEvent;
import podship.travel.EventDeck;
import podship.travel.TravelStats;

/**
 * Contains methods for the post-launch stage.
 *
 * @author tgtapio
 */
public class TravelLogic {

    private EventDeck eventDeck;
    private List<Integer> eventIDs;
    private TravelStats stats;
    private int distance;
    private Random r;

    /**
     * This empty constructor is for testing use only. For the game, use the
     * constructor with parameters instead.
     */
    public TravelLogic() {
        eventDeck = new EventDeck();
        eventIDs = new ArrayList<>();
        stats = new TravelStats();
        distance = 6; // debug value
        r = new Random();
    }

    /**
     * Constructor initialises the post-launch stage with the parameters
     * received.
     *
     * @param stats holds the resources for this voyage.
     * @param eventIDs holds the IDs for unlocked events for this voyage.
     */
    public TravelLogic(TravelStats stats, List<Integer> eventIDs) {
        this.eventDeck = new EventDeck();
        this.eventIDs = eventIDs;
        this.stats = stats;
        r = new Random();
        distance = 4 + r.nextInt(4);

        for (int i = 0; i < distance + 1; i++) {
            this.eventDeck.addEvent(new TravelEvent());
        }
    }

    /**
     * Executes one travel turn. Event occurs if ship has enough resources for
     * it, otherwise peaceful travel continues. If no events are left, peaceful
     * travel ensues.
     *
     */
    public String proceedJourney() {
        String entry = "";
        distance--;
        TravelEvent e = null;
        if (eventDeck.getDeckSize() > 0) {
            e = (TravelEvent) eventDeck.getNextEvent();
        }

        if (e != null && stats.hasEnoughResources(e.getStatRequirements())) {
            entry = e.getDesc();
            stats.adjustResources(e.getStatAdjustments());
        } else {
            entry = "Journey continues peacefully.";
        }

        // Standard travel adjustment/cost
        stats.adjustResources(new int[]{-1, 0, 0, -1, -1, 0, -1});

        return entry;
    }

    /**
     * Description of a successful travel.
     *
     * @return String for successful arrival log entry.
     */
    public String getArrivalText() {
        return "Congratulations, the ship arrived and the trek is complete!\n\n"
                + "Humanity has expanded its existence Gliese 832!\n\n\n"
                + "Your final score is " + (stats.countScore() + 100) + ".\n"
                + "Game over.\n";
    }

    /**
     * Descriptin of a failed voyage.
     *
     * @return String for failed journey.
     */
    public String getFailureText() {

        return "The ship ran out of critical resources and the mission was a failure.\n\n"
                + "Let's hope that likely catastrophe didn't wipe us all out back in Sol...\n\n\n"
                + "Your final score is " + stats.countScore() + ".\n"
                + "Game over.\n";
    }

    /**
     * Setter for remaining int distance, i.e. how many turns before arrival.
     *
     * @param distance new value for distance.
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Getter remaining int distance, i.e. how many turns before arrival.
     *
     * @return value of int distance.
     */
    public int getDistance() {
        return distance;
    }

    /**
     * First log entry for the travel log.
     *
     * @return String for the first log entry.
     */
    String getLaunchText() {
        return "The launch was a success and the ship is on its way. "
                + "You were too old and unwell to join the crew, but at "
                + "the same time are certain that your work has saved "
                + "humanity. Bon voyage, Podship!";
    }

}
