package podship.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Event includes the description of the event, and references to options player
 * may choose from. Events are (to be) generated from the database, and picked
 * from EventDeck randomly.
 *
 * @author tgtapio
 */
public class Event {

    private String eventText;
    private List<Option> options;

    /**
     * Empty event constructor.
     */
    public Event() {
        eventText = "";
        options = new ArrayList<>();
    }

    /**
     * Create an event with description and options.
     *
     * @param eventText Description of the event for the player.
     * @param options List of Options player can choose from during this event.
     */
    public Event(String eventText, ArrayList<Option> options) {
        this.eventText = eventText;
        this.options = options;
    }

    /**
     * Setter for event description.
     *
     * @param eventText String of event description.
     */
    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    /**
     * Getter for event description.
     *
     * @return String of event description.
     */
    public String getEventText() {
        return eventText;
    }

    /**
     * Add options to Event after construction.
     *
     * @param o Option to be added.
     */
    public void addOption(Option o) {
        options.add(o);
    }

    /**
     * Getter for available Options.
     *
     * @return ArrayList of options available for this event.
     */
    public List<Option> getOptions() {
        return options;
    }

}
