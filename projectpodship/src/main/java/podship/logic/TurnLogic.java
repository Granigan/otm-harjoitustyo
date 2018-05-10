package podship.logic;

import java.util.*;
import podship.daos.*;
import podship.events.*;
import podship.travel.*;

/**
 * Contains methods for the pre-launch stage.
 *
 * @author tgtapio
 */
public class TurnLogic {

    private EventDeck eventDeck;
    private EventDao eventDao;
    private TravelStats stats;
    private int turnCount;
    private String name;
    private Scanner input;
    private List<Integer> travelEventIDs;

    /**
     * Default constructor used for testing.
     */
    public TurnLogic() {
        eventDeck = new EventDeck();
        // INIT from mockDAO, later from DB
        eventDao = new EventDao();
        travelEventIDs = new ArrayList<>();
        for (BuildEvent e : eventDao.getTurnEventsDB()) {
            eventDeck.addEvent(e);
        }
        turnCount = eventDeck.getDeckSize() - 3; // during debug, turns == events-3
        stats = new TravelStats();
        name = "";
        input = new Scanner(System.in);

    }

    /**
     * Constructor initialises the pre-launch stage
     */
    public TurnLogic(TravelStats stats) {
        eventDeck = new EventDeck();
        // INIT from mockDAO, later from DB
        eventDao = new EventDao();
        travelEventIDs = new ArrayList<>();
        for (BuildEvent e : eventDao.getTurnEventsDB()) {
            eventDeck.addEvent(e);
        }
        turnCount = eventDeck.getDeckSize() - 3; // during debug, turns == events-3
        this.stats = stats;
        name = this.stats.getDirectorName();
        input = new Scanner(System.in);
    }

    /**
     * Runs the steps for the pre-launch-stage of the game.
     */
    public void newGame() {
        System.out.println(getIntroText());
        turnSteps();
    }

    /**
     * Makes sure name string is anything but "" and sets it as name variable.
     * ONLY USED BY tUI
     */
    public void getDirectorName() {
        System.out.println("Welcome to Podship, director. What is your name?");
        String dirName = input.nextLine();
        while (dirName.equals("")) {
            System.out.println("Please type in your name, director.");
            dirName = input.nextLine();
        }
        setName(dirName);
        // add input check here
        System.out.println("Very good. Let's get started then, director " + name + ".\n");
    }

    /**
     * Contains the intro text
     *
     * @return Returns intro text as a string.
     */
    public String getIntroText() {
        return "Welcome, director " + name + "."
                + "You've been tasked with overseeing the Project Podship.\n\n"
                + "In short, Earth is facing an existential crisis, and no one knows for sure if "
                + "we'll survive. To ensure humanity will not perish with the planet, we'll need to "
                + "colonise elsewhere. Unfortunately, our colonies in Mars and Ganymede "
                + "will still be reliant on Earth for decades to come, and thus, we must look elsewhere.\n\n"
                + "You'll oversee the construction of Podship, destined for Gliese 832.\n\n"
                + "That's 16.16 light years away.\n\n"
                + "That means the population of the ship will "
                + "not be passengers, but rather, they'll move to the ship to live and die there. "
                + "Dozens of the next generations will be born and will die inside the ship, "
                + "while it travels.\n\n"
                + "I'm sure you understand the enormity of the task. But you must succeed.\n\n"
                + "Good luck, director " + name;
    }

    public ArrayList<Option> getIntroOptions() {
        ArrayList<Option> options = new ArrayList<>();
        options.add(new Option("I understand"));
        options.add(new Option("I will not fail!"));
        options.add(new Option("Let's get started."));
        return options;
    }

    public BuildEvent getFirstEvent() {
        return new BuildEvent(getIntroText(), getIntroOptions());
    }

    public BuildEvent getLaunchEvent() {
        String launchText = "Time has ran out, director. We must launch the ship "
                + "now and hope for the best.\n\n"
                + "Say your prayers and complete any last rites, and when you're "
                + "ready, launch the ship.\n\n"
                + "Good luck to us all!";
        ArrayList<Option> options = new ArrayList<>();
        options.add(new Option("Launch the ship"));
        options.add(new Option("IGNITE!"));
        options.add(new Option("3... 2... 1... Lift-off!"));
        return new BuildEvent(launchText, options);
    }

    /**
     * Loops the turn logic until launched. tUI only.
     */
    public void turnSteps() {
        while (true) {
            makeADecision();
            turnCount--;
            if (checkForLaunch()) {
                break;
            }
        }

    }

    /**
     * Includes a check for turns remaining and asks the player if they want to
     * launch.
     *
     * @return Returns true if player chooses to launch or if time runs out.
     * Otherwise returns false.
     */
    public boolean checkForLaunch() {
        if (turnCount == 0) {
            return true;
        }

//        if (turnCount > 0) {
//            System.out.println("You have time for " + turnCount + " more decision(s).");
//        } else {
//            System.out.println("Time has come to an end. We must launch now.");
//            return true;
//        }
//
//        System.out.println("Is the ship ready for launch?\n(Y)es for launch, otherwise "
//                + "continue the process.");
//        String launch = input.nextLine();
//        // add input check here
//        if (launch.equals("y") || launch.equals("Y")) {
//            return true;
//        } else {
//            System.out.println("We'll continue the construction and recruitment process. You "
//                    + "have " + turnCount + " turns left before the mandatory launch date.");
        return false;
//        }
    }

    public BuildEvent getNextEvent() {
        BuildEvent be = (BuildEvent) eventDeck.getNextEvent();
        return be;
    }

    /**
     * Method presents the turn event and creates a list of options for player
     * to choose.
     */
    public void makeADecision() {
        System.out.println("It's time to make a decision, director " + name + ".\n");
        BuildEvent e = (BuildEvent) eventDeck.getNextEvent();
        System.out.println(e.getDesc());
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
        travelEventIDs.addAll(options[selection - 1].getUnlocks());
    }

    /**
     * Prints the launch confirmation and creates and returns TravelLogic to be
     * used in the second stage.
     *
     * @return Prov
     */
    public TravelLogic launchShip() {
        System.out.println("Congratulations, the ship is now launched.\n");
        System.out.println(stats.toString());
        System.out.println("Now we can but wait.");
        return new TravelLogic(stats, travelEventIDs);
    }

    /**
     * Setter for int turnCount, shows how many turns are left before mandatory
     * launch.
     *
     * @param turnCount new value for turnCount
     */
    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    /**
     * Setter for string Name, i.e. captains name.
     *
     * @param name new value for name
     */
    public void setName(String name) {
        this.name = name;
    }

}
