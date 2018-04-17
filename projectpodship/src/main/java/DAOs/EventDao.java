package DAOs;

import java.util.ArrayList;
import java.util.List;
import podship.events.Event;
import podship.events.Option;

public class EventDao {

    // all the events to be placed into db later
    private List<Event> buildEventsDB;

    public EventDao() {
        buildEventsDB = new ArrayList<>();
        captainEvent();
        popEvent();
    }

    private void captainEvent() {
        Option pickAIonly = new Option("AI alone", new int[]{0, -2, 2, 0, -2, 0, 0});
        Option pickCivvy = new Option("Elected civilian captain with AI support", new int[]{0, -1, 1, 0, 0, 0, 0});
        Option pickMilitary = new Option("Highest ranking military officer, with AI", new int[]{0, -1, 0, 0, 1, 0, 0});
        ArrayList<Option> capOptions = new ArrayList<>();
        capOptions.add(pickAIonly);
        capOptions.add(pickCivvy);
        capOptions.add(pickMilitary);

        Event pickCaptain = new Event("Decide how will the ship choose its captain.", capOptions);

        buildEventsDB.add(pickCaptain);
    }

    private void popEvent() {
        Event pickPop = new Event();
        pickPop.setEventText("How should we form the population for the ship?");
        pickPop.addOption(new Option("The Elite: The brightest are pressured to go, "
                + "the richest buy their way in.",
                new int[]{0, -2, -1, -1, 1, 0, -1}));
        pickPop.addOption(new Option("The Desperate: Those we can spare, generally "
                + "under-educated but eager to go.",
                new int[]{0, 0, 2, 0, 1, 0, 0}));
        pickPop.addOption(new Option("A Cross Section of society: include every "
                + "level of society in the same scale.",
                 new int[]{0, 0, 0, 0, 1, 0, 0}));
        buildEventsDB.add(pickPop);
    }

    public List<Event> getBuildEventsDB() {
        return buildEventsDB;
    }

}
