import java.util.Objects;

public class Player {
    private final String name;
    private Integer score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void wonPoint() {
        score++;
    }

    public Boolean isCalled(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }

    public Boolean hasWonAgainst(Player opponent) {
        int advantageOverOpponent = score - opponent.getScore();
        return score >= 4 && advantageOverOpponent >= 2;
    }

    public Boolean hasAdvantageOver(Player opponent) {
        Integer advantageOverOpponent = score - opponent.getScore();
        return score >= 4 && advantageOverOpponent.equals(1);
    }

    public Boolean isInATieWith(Player opponent) {
        return score.equals(opponent.getScore());
    }

    public Boolean isInADeuceWith(Player opponent) {
        return score >= 3
                && opponent.getScore() >= 3
                && isInATieWith(opponent);
    }
}
