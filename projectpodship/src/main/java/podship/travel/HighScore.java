package podship.travel;

/**
 * Holds the nickname and the score.
 *
 */
public class HighScore implements Comparable<Object> {

    private String name;
    private int score;

    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        HighScore other = (HighScore) o;
        return other.getScore() - this.getScore();
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
