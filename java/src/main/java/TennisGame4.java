public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(String serverName, String receiverName) {
        server = new Player(serverName);
        receiver = new Player(receiverName);
    }

    @Override
    public void wonPoint(String playerName) {
        if (server.getName().equals(playerName)) {
            server.wonPoint();
        } else {
            receiver.wonPoint();
        }
    }

    @Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GamePlayer(
                this, new AdvantagePlayer(
                this, new DefaultResult(this)))).getResult();
        return result.format();
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }
}
