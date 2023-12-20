package hangman;

public class player {
    private String name;
    private int score;

    // Constructors
    public player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        score++;
    }

    // Increment the score based on the number of attempts
    public void updateScore(int attempts) {
        if (attempts == 1) {
            score += 100;
        } else if (attempts == 2) {
            score += 60;
        } else if (attempts == 3) {
            score += 40;
        } else if (attempts == 4) {
            score += 20;
        } else {
            score += 10;
        }
    }
}
