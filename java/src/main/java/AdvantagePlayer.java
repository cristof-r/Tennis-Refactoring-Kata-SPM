public class AdvantagePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantagePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    String getPlayerNameWithAdvantage() {
        if (game.getReceiver().getScore() >= 4
                && (game.getReceiver().getScore() - game.getServer().getScore()) == 1) {
            return game.getReceiver().getName();
        }

        if (game.getServer().getScore() >= 4
                && (game.getServer().getScore() - game.getReceiver().getScore()) == 1) {
            return game.getServer().getName();
        }

        return null;
    }

    @Override
    public TennisResult getResult() {
        String playerNameWithAdvantage = getPlayerNameWithAdvantage();

        if (playerNameWithAdvantage != null) {
            return new TennisResult("Advantage " + playerNameWithAdvantage, "");
        }

        return nextResult.getResult();
    }
}
