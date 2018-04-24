package podship.travel;

public class TravelStats {

    private int[] stats;
    // 0air, 1energy, 2faith, 3food, 4morale, 5population, 6water

    public TravelStats() {
        stats = new int[7];
        for (int i : stats) {
            stats[i] = 0;
        }
    }

    public TravelStats(int[] stats) {
        this.stats = new int[7];
        for (int i = 0; i < this.stats.length; i++) {
            this.stats[i] = stats[i];
        }
    }

    public boolean hasEnoughResources(int[] requirements) {
        for (int i = 0; i < stats.length; i++) {
            if (requirements[i] > stats[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAllResources() {
        for (int i = 0; i < stats.length; i++) {
            if (stats[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public void adjustResources(int[] adjustment) {
        for (int i = 0; i < stats.length; i++) {
            stats[i] += adjustment[i];
        }
    }

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
