public class AdvantagePlayer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantagePlayer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    public String getPlayerNameWithAdvantage() {
        if (game.getReceiver().hasAdvantageOver(game.getServer())) {
            return game.getReceiver().getName();
        }

        if (game.getServer().hasAdvantageOver(game.getReceiver())) {
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
