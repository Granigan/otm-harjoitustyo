package podship.events;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private String eventText;
    private List<Option> options;

    public Event() {
        eventText = "";
        options = new ArrayList<>();
    }

    public Event(String eventText, ArrayList<Option> options) {
        this.eventText = eventText;
        this.options = options;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public String getEventText() {
        return eventText;
    }

    public void addOption(Option o) {
        options.add(o);
    }

    public List<Option> getOptions() {
        return options;
    }

}
