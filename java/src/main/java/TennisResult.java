public class TennisResult {
    private final String serverScore;
    private final String receiverScore;

    public TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    public String format() {
        if ("".equals(receiverScore)) {
            return serverScore;
        }
        if (serverScore.equals(receiverScore)) {
            return serverScore + "-All";
        }
        return serverScore + "-" + receiverScore;
    }
}
