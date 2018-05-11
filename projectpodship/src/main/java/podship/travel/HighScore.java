package podship.travel;

/**
 * Holds the nickname and the score.
 *
 */
public class HighScore implements Comparable<Object> {

    private String name;
    private int score;
    /**
     * Constructor eats names and scores and...
     * creates highscores.
     * 
     * @param name of the player
     * @param score of the player
     */
    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Overridden compareTo to use scores as comparator.
     * @param o compare to this
     * @return one with higher score
     */
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
