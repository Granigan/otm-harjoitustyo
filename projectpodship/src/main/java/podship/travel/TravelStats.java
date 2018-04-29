package podship.travel;

/**
 * TravelStats tracks the amount of resources the ship has. Events check and
 * change the amounts first during construction, then during the travel.
 * @author tgtapio
 */
public class TravelStats {

    /**
     * stats are:
     * 
     * 0 = air,
     * 1 = energy,
     * 2 = faith,
     * 3 = 3food,
     * 4 = morale,
     * 5 = population,
     * 6 = water
     */
    private int[] stats;

    /**
     * Default constructor, all stats start at 0.
     */
    public TravelStats() {
        stats = new int[7];
        for (int i : stats) {
            stats[i] = 0;
        }
    }

    /**
     * Constructor mainly for testing. Stats can be set with the parameter.
     * @param stats Sets the starting stats to this.
     */
    public TravelStats(int[] stats) {
        this.stats = new int[7];
        for (int i = 0; i < this.stats.length; i++) {
            this.stats[i] = stats[i];
        }
    }

    /**
     * Check to see if ship still has at least this many resources left.
     * @param requirements The amounts of required resources.
     * @return true if ship has at least the required amount, false if any
     * is missing.
     */
    public boolean hasEnoughResources(int[] requirements) {
        for (int i = 0; i < stats.length; i++) {
            if (requirements[i] > stats[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check to see if ship has at least 1 of every resource.
     * @return true if all resources are greater than 0. Otherwise false.
     */
    
    public boolean hasAllResources() {
        for (int i = 0; i < stats.length; i++) {
            if (stats[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    
    /**
     * Modify all the stats with the input values.
     * @param adjustment add these to the existing stats.
     * (Use negative values to subtract stats.)
     */
    public void adjustResources(int[] adjustment) {
        for (int i = 0; i < stats.length; i++) {
            stats[i] += adjustment[i];
        }
    }

    /**
     * Reports the current statistics/resources.
     * @return String with all current stat values.
     */
    @Override
    public String toString() {
        return "Flight statistics are:\n"
                + stats[0] + " units of air\n"
                + stats[1] + " units of energy\n"
                + stats[2] + " units of faith\n"
                + stats[3] + " units of food\n"
                + stats[4] + " units of morale\n"
                + stats[5] + " units of population\n"
                + stats[6] + " units of water\n";
    }
}
