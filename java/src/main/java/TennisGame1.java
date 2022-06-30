import java.util.Map;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    private final Map<Integer, String> scoreNames = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
    );

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    @Override
    public void wonPoint(String playerName) {
        getPlayerByName(playerName).wonPoint();
    }

    @Override
    public String getScore() {
        if (player1.isInATieWith(player2)) {
            if (player1.getScore() > 2) {
                return "Deuce";
            } else {
                return getScoreName(player1) + "-All";
            }
        } else if (player1.hasAdvantageOver(player2)) {
            return "Advantage " + player1.getName();
        } else if (player2.hasAdvantageOver(player1)) {
            return "Advantage " + player2.getName();
        } else if (player1.hasWonAgainst(player2)) {
            return "Win for " + player1.getName();
        } else if (player2.hasWonAgainst(player1)) {
            return "Win for " + player2.getName();
        } else {
            return getScoreName(player1) + "-" + getScoreName(player2);
        }
    }

    private Player getPlayerByName(String playerName) {
        return player1.isCalled(playerName) ? player1 : player2;
    }

    private String getScoreName(Player player) {
        return scoreNames.get(player.getScore());
    }
}
