package podship.events;

import java.util.Random;

/**
 * TravelEvent includes the description of the event, and checks and adjustments
 * to TravelStats. Events are (to be) generated from the database, and picked
 * from EventDeck randomly.
 * @author tgtapio
 */
public class TravelEvent extends Event{
    
    private int[] statAdjustments;
    private int[] statRequirements;

    /**
     * Constructor for creating random events, for convenience's sake.
     * (For testing and debug.)
     */
    public TravelEvent() {
        Random r = new Random();
        statAdjustments = new int[]{r.nextInt(2)-1, r.nextInt(2)-1, r.nextInt(2)-1,
            r.nextInt(2)-1, r.nextInt(2)-1, r.nextInt(2)-1, r.nextInt(2)-1};
        statRequirements = new int[]{0, 0, 0, 0, 0, 0, 0};
        super.setDesc("A random encounter in space!");
    }

    /**
     * TravelEvent constructor with parameters.
     * @param statAdjustments Event will add the values to TravelStats.
     * @param statRequirements Event will only occur if these requirements are met.
     * @param desc Description given to the player.
     */
    public TravelEvent(int[] statAdjustments, int[] statRequirements, String desc) {
        this.statAdjustments = statAdjustments;
        this.statRequirements = statRequirements;
        super.setDesc(desc);
    }

    public int[] getStatAdjustments() {
        return statAdjustments;
    }

    public int[] getStatRequirements() {
        return statRequirements;
    }

    public void setStatAdjustments(int[] statAdjustments) {
        this.statAdjustments = statAdjustments;
    }

    public void setStatRequirements(int[] statRequirements) {
        this.statRequirements = statRequirements;
    }
}
