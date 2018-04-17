package podship.domain;

import DAOs.EventDao;
import java.util.*;
import podship.events.Event;
import podship.events.Option;
import podship.travel.EventDeck;
import podship.travel.TravelStats;

public class Main {

    // INIT from mockDAO, later from DB
    static EventDeck eventDeck;
    static EventDao eventDao;
    static TravelStats stats;
    static int turnCount;
    static String name;
    static Scanner input;

    public static void init() {
        eventDeck = new EventDeck();
        eventDao = new EventDao();
        for (Event e : eventDao.getBuildEventsDB()) {
            eventDeck.addEvent(e);
        }
        turnCount = eventDeck.getDeckSize();
        stats = new TravelStats();
        name = "";
        input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        init();

        System.out.println("Welcome to Podship, director. What is your name?");
        name = input.nextLine();
        System.out.println("Very good. Let's get started then, director " + name + ".\n");

        System.out.println("You've been tasked with overseeing the Project Podship.\n\n"
                + "In short, Earth is facing an existential crisis, and no one knows for sure if "
                + "we'll survive. To ensure humanity will not perish with the planet, we'll need to "
                + "colonise elsewhere. Unfortunately, our colonies in Mars and Ganymede "
                + "will still be reliant on Earth for decades to come, and thus, we must look elsewhere.\n");
        System.out.println("You'll oversee the construction of Podship, destined for Gliese 832.\n\n"
                + "That's 16.16 light years away.\n\n"
                + "That means the population of the ship will "
                + "not be passengers, but rather, they'll move to the ship to live and die there. "
                + "Dozens of the next generations will be born and will die inside the ship, "
                + "while it travels.\n\n"
                + "I'm sure you understand the enormity of the task. But you must succeed.\n\n"
                + "Good luck, director " + name + ".\n\n");

        turnLogic();

    }

    public static void turnLogic() {
        while (true) {
            makeADecision();
            turnCount--;
            if (checkForLaunch()) {
                launchShip();
                break;
            }
        }

    }

    public static boolean checkForLaunch() {
        if (turnCount > 0) {
            System.out.println("You have time for " + turnCount + " more decision(s).");
        } else {
            System.out.println("Time has come to an end. We must launch now.");
            return true;
        }

        System.out.println("Is the ship ready for launch?\n(y)es or (n)o");
        String launch = input.nextLine();
        if (launch.equals("y")) {
            launchShip();
            return true;
        } else if (launch.equals("n")) {
            System.out.println("We'll continue the construction and recruitment process. You "
                    + "have " + turnCount + " turns left before the mandatory launch date.");
            return false;
        }
        return false;
    }

    public static void makeADecision() {
        System.out.println("It's time to make a decision, director " + name + ".\n");
        Event e = eventDeck.getNextEvent();
        System.out.println(e.getEventText());
        System.out.println("\nYour options are:\n");
        Option[] options = new Option[e.getOptions().size()];
        int i = 0;
        for (Option o : e.getOptions()) {
            options[i] = o;
            i++;
            System.out.println(i + ") " + o.getDesc());
        }
        System.out.println("\nPlease make your selection by typing in the number.");

        int selection = Integer.parseInt(input.nextLine());

        System.out.println("You have selected option " + selection
                + ", " + options[selection - 1].getDesc() + ". Order confirmed.\n\n");

        stats.adjustResources(options[selection - 1].getStatAdjustments());
    }

    public static void launchShip() {
        System.out.println("Congratulations, the ship is now launched.\n");
        System.out.println(stats.toString());
        System.out.println("Now we can but wait.");
    }

}
