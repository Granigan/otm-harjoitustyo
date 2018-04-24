package podship.domain;

import podship.logic.TravelLogic;
import podship.logic.TurnLogic;

public class Main {

    public static void main(String[] args) {
        TurnLogic turnLogic = new TurnLogic();
        turnLogic.newGame();
        TravelLogic travelLogic = turnLogic.launchShip();
        travelLogic.travel();
    }
}
