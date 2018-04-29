package podship.logic;

import java.util.ArrayList;
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
    }

    /**
     * Logic for the travel stage, runs until arrival or failure.
     */
    public void travel() {
        while (stats.hasAllResources()) {
            proceedJourney();
            if (distance < 1) {
                arrival();
                break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (!stats.hasAllResources()) {
            failure();
        }

    }

    /**
     * Debug/default travel event. Reduces consumable stats (air, energy, food,
     * water) by 1.
     */
    public void proceedJourney() {
        distance--;
//        TravelEvent e = (TravelEvent) eventDeck.getNextEvent();
        System.out.println("Journey continues peacefully. "
                + distance + " turns until arrival.");
        stats.adjustResources(new int[]{-1, 0, 0, -1, -1, 0, -1});
        System.out.println(stats.toString());
        System.out.println("\n\n");
    }

    /**
     * Successful arrival logic.
     */
    public void arrival() {
        System.out.println("Congratulations, the ship arrived and the trek is complete!\n\n"
                + "Humanity has expanded its existence Gliese 832!\n\n\n"
                + "Game over.\n");
    }

    /**
     * Voyage ends in failure.
     */
    public void failure() {
        System.out.println("The ship ran out of critical resources and the mission was a failure.\n\n"
                + "Let's hope that likely catastrophe didn't wipe us all out back in Sol...\n\n\n"
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
