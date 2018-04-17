package podship.events;

import java.util.ArrayList;
import java.util.List;

public class Option {

    private String desc;
    private int[] statAdjustments;
    private List<Integer> unlocks;

    public Option() {
        desc = "";
        statAdjustments = new int[]{0, 0, 0, 0, 0, 0, 0};
        unlocks = new ArrayList<>();
    }

    public Option(String desc, int[] stats) {
        this.desc = desc;
        statAdjustments = new int[7];
        for (int i = 0; i < statAdjustments.length; i++) {
            statAdjustments[i] = stats[i];
        }
    }

    public String getDesc() {
        return desc;
    }

    public int[] getStatAdjustments() {
        return statAdjustments;
    }

    public void addUnlock(int id) {
        unlocks.add(id);
    }

    public List<Integer> getUnlocks() {
        return unlocks;
    }

}
