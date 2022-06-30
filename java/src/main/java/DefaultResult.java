public class DefaultResult implements ResultProvider {

    private static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(SCORES[game.getServer().getScore()], SCORES[game.getReceiver().getScore()]);
    }
}
