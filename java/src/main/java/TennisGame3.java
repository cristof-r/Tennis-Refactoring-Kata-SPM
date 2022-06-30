
public class TennisGame3 implements TennisGame {

    private int player1;
    private int player2;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String standing;
        if (scoreIsLow()) {
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            standing = points[player1];
            return getLowScoreString(standing, points);
        } else {
            if (player1 == player2)
                return "Deuce";
            standing = player1 > player2 ? player1Name : player2Name;
            return getHighScoreString(standing);
        }
    }

    private String getHighScoreString(String standing) {
        return ((player1 - player2) * (player1 - player2) == 1) ? "Advantage " + standing : "Win for " + standing;
    }

    private String getLowScoreString(String standing, String[] points) {
        return (player1 == player2) ? standing + "-All" : standing + "-" + points[player2];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1 += 1;
        else
            this.player2 += 1;
        
    }

    private boolean scoreIsLow(){
        return player1 < 4 && player2 < 4 && !(player1 + player2 == 6);
    }

}
