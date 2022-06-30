
public class TennisGame2 implements TennisGame
{
    Player player1;
    Player player2;

    public String player1Standing = "";
    public String player2Standing = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore(){
        if (player1.getScore().equals(player2.getScore()) && player1.getScore()>=3)
            return "Deuce";

        if (player1.getScore().equals(player2.getScore()))
        {
            return score2Text(player1.getScore()) + "-All";
        }

        if (player1.hasAdvantageOver(player2))
        {
            return "Advantage player1";
        }
        
        if (player2.hasAdvantageOver(player1))
        {
            return "Advantage player2";
        }
        
        if (player1.hasWonAgainst(player2))
        {
            return "Win for player1";
        }
        if (player2.hasWonAgainst(player1))
        {
            return "Win for player2";
        }

        playerAhead(player1.getScore(),player2.getScore(), player1.getName());
        playerAhead(player2.getScore(), player1.getScore(), player2.getName());

        return player1Standing + "-" + player2Standing;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String score2Text(Integer score){
        String scoreText;
        scoreText = "Love";
        if (score==1)
            scoreText = "Fifteen";
        if (score==2)
            scoreText = "Thirty";
        if (score==3)
            scoreText = "Forty";
        return scoreText;
    }

    public void playerAhead(Integer p1, Integer p2, String playerName){
        if(p1>p2 && p1 <4){
            if(playerName.equals("player1")){
                player1Standing = score2Text(p1);
                player2Standing = score2Text(p2);
            }
            if(playerName.equals("player2")){
                player1Standing = score2Text(p2);
                player2Standing = score2Text(p1);
            }
        }
    }
}