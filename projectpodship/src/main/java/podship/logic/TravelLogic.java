package podship.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import podship.travel.EventDeck;
import podship.travel.TravelStats;

public class TravelLogic {

    private EventDeck eventDeck;
    private List<Integer> eventIDs;
    private TravelStats stats;
    private int distance;

    // for testing use, use the constructor with parameters instead
    public TravelLogic() {
        eventDeck = new EventDeck();
        eventIDs = new ArrayList<>();
        stats = new TravelStats();
        distance = 6; // debug value
    }

    public TravelLogic(TravelStats stats, List<Integer> eventIDs) {
        this.eventDeck = new EventDeck();
        this.eventIDs = eventIDs;
        this.stats = stats;
        distance = 6; // debug value
    }

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

    private void proceedJourney() {
        distance--;
        System.out.println("Journey continues peacefully. "
                + distance + " turns until arrival.");
        stats.adjustResources(new int[]{-1, 0, 0, -1, -1, 0, -1});
        System.out.println(stats.toString());
        System.out.println("\n\n");
    }

    private void arrival() {
        System.out.println("Congratulations, the ship arrived and the trek is complete!\n\n"
                + "Humanity has expanded its existence Gliese 832!\n\n\n"
                + "Game over.\n");
    }

    private void failure() {
        System.out.println("The ship ran out of critical resources and the mission was a failure.\n\n"
                + "Let's hope that likely catastrophe didn't wipe us all out back in Sol...\n\n\n"
                + "Game over.\n");
    }

}
