package podship.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import podship.events.BuildEvent;
import podship.events.Option;

public class EventDao {

    // all the events to be placed into db later
    public EventDao() {
    }

    public List<BuildEvent> getTurnEventsDB() {
        List<BuildEvent> turnEventsDB = new ArrayList<>();
        turnEventsDB.add(captainEvent());
        turnEventsDB.add(popEvent());
        for (int i = 0; i < 10; i++) {
            turnEventsDB.add(debugEvent());
        }
        return turnEventsDB;
    }

    // These from DB in final
    private BuildEvent captainEvent() {
        Option pickAIonly = new Option("AI alone", new int[]{0, -2, 2, 0, -2, 0, 0}, new ArrayList<Integer>());
        Option pickCivvy = new Option("Elected civilian captain with AI support", new int[]{0, -1, 1, 0, 0, 0, 0}, new ArrayList<Integer>());
        Option pickMilitary = new Option("Highest ranking military officer, with AI", new int[]{0, -1, 0, 0, 1, 0, 0}, new ArrayList<Integer>());
        ArrayList<Option> capOptions = new ArrayList<>();
        capOptions.add(pickAIonly);
        capOptions.add(pickCivvy);
        capOptions.add(pickMilitary);

        BuildEvent pickCaptain = new BuildEvent("Decide how will the ship choose its captain.", capOptions);

        return pickCaptain;
    }

    private BuildEvent popEvent() {
        BuildEvent pickPop = new BuildEvent();
        pickPop.setDesc("How should we form the population for the ship?");
        pickPop.addOption(new Option("The Elite: The brightest are pressured to go, "
                + "the richest buy their way in.",
                new int[]{0, -2, -1, -1, 1, 0, -1}, new ArrayList<Integer>()));
        pickPop.addOption(new Option("The Desperate: Those we can spare, generally "
                + "under-educated but eager to go.",
                new int[]{0, 0, 2, 0, 1, 0, 0}, new ArrayList<Integer>()));
        pickPop.addOption(new Option("A Cross Section of society: include every "
                + "level of society in the same scale.",
                new int[]{0, 0, 0, 0, 1, 0, 0}, new ArrayList<Integer>()));
        return pickPop;
    }

    // DEBUG
    private BuildEvent debugEvent() {
        Random r = new Random();
        BuildEvent debug = new BuildEvent();
        debug.setDesc("DEBUG-event");
        debug.addOption(new Option("first option", new int[]{5, 5, 5, 5, 5, 5, 5}, new ArrayList<Integer>()));
        debug.addOption(new Option("second option", new int[]{-5, -5, -5, -5, -5, -5, -5}, new ArrayList<Integer>()));
        debug.addOption(new Option("third option",
                new int[]{r.nextInt(10) - 5, r.nextInt(10) - 5, r.nextInt(10) - 5, r.nextInt(10) - 5,
                    r.nextInt(10) - 5, r.nextInt(10) - 5, r.nextInt(10) - 5}, new ArrayList<Integer>()));
        return debug;
    }

}
