package podship.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import podship.events.BuildEvent;
import podship.events.Event;

/**
 * EventDeck is the pool of available BuildEvent objects. New events can be added,
 * and a random event be chosen.
 *
 * @author tgtapio
 */
public class EventDeck {

    private List<Event> availableEvents;

    /**
     * Default constructor.
     */
    public EventDeck() {
        availableEvents = new ArrayList<>();
    }

    /**
     * Add an event to the deck.
     *
     * @param e the event to be added to the pool of available events.
     */
    public void addEvent(Event e) {
        availableEvents.add(e);
    }

    /**
     * Call to get the next event out of the available ones.
     *
     * @return Returns a randomly picked event from the unlocked events.
     */
    public Event getNextEvent() {
        Random r = new Random();
        return availableEvents.remove(r.nextInt(availableEvents.size()));
    }

    /**
     * Used for checking if there are events left.
     *
     * @return Returns the number of events left in the deck.
     */
    public int getDeckSize() {
        return availableEvents.size();
    }
}
