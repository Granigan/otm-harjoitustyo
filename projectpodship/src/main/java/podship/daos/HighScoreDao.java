package podship.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import podship.travel.HighScore;

/**
 * Mock DAO for highscores, autofills the list on application start.
 * Data is not permanent.
 */
public class HighScoreDao {

    private List<HighScore> hiscores;

    /**
     * Constructor calls generateTopScores to fill in mock data to the list.
     */
    public HighScoreDao() {
        hiscores = new ArrayList<>();
        generateTopScores();
    }

    /**
     * Used to insert a new entry to the high score list. Adds the entry, sorts, 
     * and trims the list so that only top-5 remain.
     * @param name of the player
     * @param score of the player
     */
    public void addNewEntry(String name, int score) {
        hiscores.add(new HighScore(name, score));
        Collections.sort(hiscores);
        while (hiscores.size() > 5) {
            hiscores.remove(hiscores.size() - 1);
        }
    }

    public List<HighScore> getHiscores() {
        return hiscores;
    }

    /**
     * Mock data generator to fill in the list at start.
     */
    public void generateTopScores() {
        addNewEntry("Qmppu", 303);
        addNewEntry("Granigan", 28);
        addNewEntry("Granigan", 140);
        addNewEntry("Juhq", 176);
        addNewEntry("Granigan", 178);
        addNewEntry("Granigan", -20);
    }

    /**
     * Formats the top-5 list nicely
     * @return formatted high scores list
     */
    @Override
    public String toString() {
        String topScores = "";
        for (int i = 0; i < hiscores.size(); i++) {
            topScores += "" + (1 + i) + ") " + hiscores.get(i).getScore() + "\t"
                    + hiscores.get(i).getName() + "\n";
        }
        return topScores;
    }

}
