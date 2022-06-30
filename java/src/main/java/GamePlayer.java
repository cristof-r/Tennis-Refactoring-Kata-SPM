public class GamePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GamePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasWon()) {
            return new TennisResult("Win for " + game.getServer().getName(), "");
        }
        if (game.receiverHasWon()) {
            return new TennisResult("Win for " + game.getReceiver().getName(), "");
        }
        return nextResult.getResult();
    }
}
