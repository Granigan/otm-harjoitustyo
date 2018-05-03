package podship.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    /**
     * This empty constructor is for testing use only. For the game, use the
     * constructor with parameters instead.
     */
    public TravelLogic() {
        eventDeck = new EventDeck();
        eventIDs = new ArrayList<>();
        stats = new TravelStats();
        distance = 6; // debug value
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
        distance = 6; // debug value

        for (int i = 0; i < distance + 1; i++) {
            this.eventDeck.addEvent(new TravelEvent());
        }
    }

    /**
     * Logic for the travel stage, runs until arrival or failure.
     */
    public void travel() {
        if (!stats.hasAllResources()) {
            failure();
        }
        while (stats.hasAllResources()) {
            proceedJourney();
            if (distance < 1) {
                arrival();
                break;
            }
            if (!stats.hasAllResources()) {
                failure();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    /**
     * Executes one travel turn. Event occurs if ship has enough resources for
     * it, otherwise peaceful travel continues.
     */
    public void proceedJourney() {
        distance--;
        TravelEvent e = null;
        if (eventDeck.getDeckSize() > 0) {
            e = (TravelEvent) eventDeck.getNextEvent();
        }

        if (e != null && stats.hasEnoughResources(e.getStatRequirements())) {
            System.out.println(e.getDesc() + "\n" + distance + " turns until arrival.\n");
            stats.adjustResources(e.getStatAdjustments());
        } else {
            System.out.println("Journey continues peacefully. "
                    + distance + " turns until arrival.");
        }

        // Standard travel adjustment/cost
        stats.adjustResources(new int[]{-1, 0, 0, -1, -1, 0, -1});

        System.out.println(stats.toString());
        System.out.println("\n");
    }

    /**
     * Successful arrival logic.
     */
    public void arrival() {
        System.out.println("Congratulations, the ship arrived and the trek is complete!\n\n"
                + "Humanity has expanded its existence Gliese 832!\n\n\n"
                + "Your final score is " + (stats.countScore() + 100) + ".\n"
                + "Game over.\n");
    }

    /**
     * Voyage ends in failure.
     */
    public void failure() {
        System.out.println("The ship ran out of critical resources and the mission was a failure.\n\n"
                + "Let's hope that likely catastrophe didn't wipe us all out back in Sol...\n\n\n"
                + "Your final score is " + stats.countScore() + ".\n"
                + "Game over.\n");
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

}
