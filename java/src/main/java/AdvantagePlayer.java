public class AdvantagePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantagePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasAdvantage()) {
            return new TennisResult("Advantage " + game.getReceiver().getName(), "");
        }
        if (game.serverHasAdvantage()) {
            return new TennisResult("Advantage " + game.getServer().getName(), "");
        }
        return nextResult.getResult();
    }
}
