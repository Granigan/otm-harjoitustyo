package podship.events;

/**
 * Superclass for events.
 *
 * @author tgtapio
 */
abstract public class Event {

    protected String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
