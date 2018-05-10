package podship.logic;

import podship.travel.TravelStats;

/**
 * Creates the classes for a new game and launches it
 */
public class GameLogic {

    private TravelStats stats;
    private TurnLogic turnLogic;

    public GameLogic() {
    }

    public void newGame(String name, int[] stats) {
        this.stats = new TravelStats(name, stats);
        turnLogic = new TurnLogic(this.stats);
    }

    public TravelStats getStats() {
        return stats;
    }

    public TurnLogic getTurnLogic() {
        return turnLogic;
    }
    
    

    public void runGame() {
        turnLogic.newGame();
        TravelLogic travelLogic = turnLogic.launchShip();
        travelLogic.travel();
    }

}
