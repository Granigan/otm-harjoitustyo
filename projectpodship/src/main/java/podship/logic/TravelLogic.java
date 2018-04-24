package podship.logic;

import java.util.ArrayList;
import java.util.List;
import podship.travel.EventDeck;
import podship.travel.TravelStats;

public class TravelLogic {

    private EventDeck eventDeck;
    private List<Integer> eventIDs;
    private TravelStats stats;

    public TravelLogic() {
        eventDeck = new EventDeck();
        eventIDs = new ArrayList<>();
        stats = new TravelStats();
        System.out.println("travel logic init complete");
    }

    public TravelLogic(TravelStats stats, List<Integer> eventIDs) {
        this.eventDeck = new EventDeck();
        this.eventIDs = eventIDs;
        this.stats = stats;
        System.out.println("travel logic init complete");
    }

}
