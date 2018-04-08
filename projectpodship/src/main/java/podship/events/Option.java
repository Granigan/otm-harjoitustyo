package podship.events;

public class Option {

    private String desc;
    private int[] statAdjustments;

    public Option() {
        desc = "";
        statAdjustments = new int[]{0, 0, 0, 0, 0, 0, 0};
    }
    
    public Option(String desc, int[] stats) {
        this.desc = desc;
        statAdjustments = new int[7];
        for(int i = 0; i < statAdjustments.length; i++) {
            statAdjustments[i] = stats[i];
        }
    }
    
    public String getDesc() {
        return desc;
    }

    public int[] getStatAdjustments() {
        return statAdjustments;
    }
    
    
}
