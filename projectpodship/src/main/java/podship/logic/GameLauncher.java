/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podship.logic;

import podship.travel.TravelStats;

/**
 * Creates the classes for a new game and launches it
 */
public class GameLauncher {
    
    String directorName;
    TravelStats stats;

    public GameLauncher(String directorName, int[] startingStats) {
        this.stats = new TravelStats(directorName, startingStats);
    }
    
    public void runGame() {
        TurnLogic turnLogic = new TurnLogic(stats);
        turnLogic.newGame();
        TravelLogic travelLogic = turnLogic.launchShip();
        travelLogic.travel();
    }
    
    
}
