
public class TennisGame3 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        String standing;
        if (scoreIsLow()) {
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            standing = points[player1.getScore()];
            return getLowScoreString(standing, points);
        } else {
            if (player1.getScore().equals(player2.getScore()))
                return "Deuce";
            standing = player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();
            return getHighScoreString(standing);
        }
    }

    private String getHighScoreString(String standing) {
        return ((player1.getScore() - player2.getScore()) * (player1.getScore() - player2.getScore()) == 1) ? "Advantage " + standing : "Win for " + standing;
    }

    private String getLowScoreString(String standing, String[] points) {
        return (player1.getScore().equals(player2.getScore())) ? standing + "-All" : standing + "-" + points[player2.getScore()];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1.wonPoint();
        else
            player2.wonPoint();
        
    }

    private boolean scoreIsLow(){
        return player1.getScore() < 4 && player2.getScore() < 4 && !(player1.getScore() + player2.getScore() == 6);
    }

}
