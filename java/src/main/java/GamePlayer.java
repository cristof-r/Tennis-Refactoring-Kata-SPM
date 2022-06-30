public class GamePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GamePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    String getPlayerNameWithWin() {
        if (game.getReceiver().hasWonAgainst(game.getServer()))
            return game.getReceiver().getName();

        if (game.getServer().hasWonAgainst(game.getReceiver())) {
            return game.getServer().getName();
        }

        return null;
    }

    @Override
    public TennisResult getResult() {
        String playerNameWithWin = getPlayerNameWithWin();

        if (playerNameWithWin != null) {
            return new TennisResult("Win for " + playerNameWithWin, "");
        }

        return nextResult.getResult();
    }
}
