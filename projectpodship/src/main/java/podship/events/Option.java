package podship.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Option class contains the description of the option, stat adjustment array,
 * and IDs of events it unlocks. Options are (to be) populated from the database
 * and are always linked to an event.
 *
 * @author tgtapio
 */
public class Option {

    private String desc;
    private int[] statAdjustments;
    private List<Integer> unlocks;

    /**
     * Empty constructor for Option. Mainly for testing. Desc is "", adjustments
     * all zero, empty list for unlocks.
     */
    public Option() {
        desc = "";
        statAdjustments = new int[]{0, 0, 0, 0, 0, 0, 0};
        unlocks = new ArrayList<>();
    }

    /**
     * Simplified constructor for Option, used to initialise building/turn
     * phase. Modifiers are all zero, empty list for unlocks.
     *
     * @param desc is shown in the GUI
     */
    public Option(String desc) {
        this.desc = desc;
        statAdjustments = new int[]{0, 0, 0, 0, 0, 0, 0};
        unlocks = new ArrayList<>();
    }

    /**
     * Default constructor for an option.
     *
     * @param desc is shown in the GUI
     * @param stats picking the Option causes these stat modifiers to the ship.
     * @param unlocks picking the Option unlocks travel events with these IDs.
     */
    public Option(String desc, int[] stats, List<Integer> unlocks) {
        this.desc = desc;
        statAdjustments = new int[7];
        for (int i = 0; i < statAdjustments.length; i++) {
            statAdjustments[i] = stats[i];
        }
        this.unlocks = unlocks;
    }

    /**
     * Getter for the description.
     *
     * @return Describes the option. Seen in the TurnScene GUI.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter for stats adjustments array. Modifiers can be negative or
     * positive.
     *
     * @return Array of modifiers for the stats.
     */
    public int[] getStatAdjustments() {
        return statAdjustments;
    }

    /**
     * Used to add event unlock ID to an Option. If the Option is picked it
     * unlocks the events for the travel.
     *
     * @param id Choosing this option unlocks event with this ID.
     */
    public void addUnlock(int id) {
        unlocks.add(id);
    }

    /**
     * Getter for unlock list.
     *
     * @return This option unlocks all these events for the voyage.
     */
    public List<Integer> getUnlocks() {
        return unlocks;
    }

}
