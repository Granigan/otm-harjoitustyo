package podship.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import podship.travel.HighScore;

/**
 * Mock DAO for highscores
 */
public class HighScoreDao {

    private List<HighScore> hiscores;

    public HighScoreDao() {
        hiscores = new ArrayList<>();
        generateTopScores();
    }

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

    public void generateTopScores() {
        addNewEntry("Qmppu", 303);
        addNewEntry("Granigan", 28);
        addNewEntry("Granigan", 140);
        addNewEntry("Juhq", 176);
        addNewEntry("Granigan", 178);
        addNewEntry("Granigan", -20);
    }

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
