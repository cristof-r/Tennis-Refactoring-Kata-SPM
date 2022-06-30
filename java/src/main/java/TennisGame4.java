import java.util.Objects;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(String serverName, String receiverName) {
        server = new Player(serverName);
        receiver = new Player(receiverName);
    }

    @java.lang.Override
    public void wonPoint(String playerName) {
        if (server.getName().equals(playerName)) {
            server.wonPoint();
        } else {
            receiver.wonPoint();
        }
    }

    @java.lang.Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GamePlayer(
                this, new AdvantagePlayer(
                this, new DefaultResult(this)))).getResult();
        return result.format();
    }

    boolean receiverHasAdvantage() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) == 1;
    }

    boolean serverHasAdvantage() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) == 1;
    }

    boolean receiverHasWon() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) >= 2;
    }

    boolean serverHasWon() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) >= 2;
    }

    boolean isDeuce() {
        return server.getScore() >= 3 && receiver.getScore() >= 3 && (Objects.equals(server.getScore(), receiver.getScore()));
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }
}
