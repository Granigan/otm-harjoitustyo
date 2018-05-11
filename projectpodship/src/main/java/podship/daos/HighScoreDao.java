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

    public void newEntry(String name, int score) {
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
        newEntry("Qmppu", 303);
        newEntry("Granigan", 28);
        newEntry("Granigan", 140);
        newEntry("Granigan", -4);
        newEntry("Juhq", 176);
        newEntry("Granigan", 178);
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
