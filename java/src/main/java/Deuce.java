import java.util.Objects;

public class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    boolean isDeuce() {
        return game.getServer().getScore() >= 3
                && game.getReceiver().getScore() >= 3
                && (Objects.equals(game.getServer().getScore(), game.getReceiver().getScore()));
    }
    
    @Override
    public TennisResult getResult() {
        if (isDeuce()) {
            return new TennisResult("Deuce", "");
        }
        return nextResult.getResult();
    }
}
