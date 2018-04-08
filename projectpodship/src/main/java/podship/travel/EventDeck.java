package podship.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import podship.events.Event;

public class EventDeck {
    private List<Event> availableEvents;
    
    public EventDeck() {
        availableEvents = new ArrayList<>();
    }
    
    public void addEvent(Event e) {
        availableEvents.add(e);
    }
    
    public Event getNextEvent() {
        Random r = new Random();
        return availableEvents.remove(r.nextInt(availableEvents.size()));
    }
    
    public int getDeckSize() {
        return availableEvents.size();
    }
}
