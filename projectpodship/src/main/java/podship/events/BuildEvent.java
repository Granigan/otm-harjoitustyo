package podship.events;

import java.util.ArrayList;
import java.util.List;

/**
 * BuildEvent includes the description of the event, and references to options
 * player may choose from. Events are (to be) generated from the database, and
 * picked from EventDeck randomly.
 *
 * @author tgtapio
 */
public class BuildEvent extends Event {

    private List<Option> options;

    /**
     * Empty event constructor. Desc is "" and Option list is empty.
     */
    public BuildEvent() {
        super.setDesc("");
        options = new ArrayList<>();
    }

    /**
     * Create an event with description and options.
     *
     * @param eventText Description of the event for the player.
     * @param options List of Options player can choose from during this event.
     */
    public BuildEvent(String eventText, ArrayList<Option> options) {
        super.setDesc(eventText);
        this.options = options;
    }

    /**
     * Add options to BuildEvent after construction.
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
