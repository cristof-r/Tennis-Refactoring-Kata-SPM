public class GamePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GamePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    String getPlayerNameWithWin() {
        if (game.getReceiver().getScore() >= 4
                && (game.getReceiver().getScore() - game.getServer().getScore()) >= 2) {
            return game.getReceiver().getName();
        }

        if (game.getServer().getScore() >= 4
                && (game.getServer().getScore() - game.getReceiver().getScore()) >= 2) {
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
