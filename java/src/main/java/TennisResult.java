public class TennisResult {
    String serverScore;
    String receiverScore;

    TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    String format() {
        if ("".equals(receiverScore)) {
            return serverScore;
        }
        if (serverScore.equals(receiverScore)) {
            return serverScore + "-All";
        }
        return serverScore + "-" + receiverScore;
    }
}
