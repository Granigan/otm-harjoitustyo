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
     * Empty constructor for an option. Mainly for testing.
     */
    public Option() {
        desc = "";
        statAdjustments = new int[]{0, 0, 0, 0, 0, 0, 0};
        unlocks = new ArrayList<>();
    }

    /**
     * Default constructor for an option.
     *
     * @param desc String of option description.
     * @param stats Choosing this option causes these stat modifiers.
     * @param unlocks This option unlocks travel events with these IDs.
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
     * @return Describes the option.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter for stat adjustments array.
     *
     * @return Array of modifiers for the stats.
     */
    public int[] getStatAdjustments() {
        return statAdjustments;
    }

    /**
     * Used to add event unlock ID to an Option.
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
