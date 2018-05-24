
public class TennisGame2 implements TennisGame {
    private int p1point = 0;
    private int p2point = 0;

    private String p1res = "";
    private String p2res = "";
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score;

        if (p1point == p2point) {
            score = scoreWhenTie(p1point);
        } else {
            score = initializeScore();

            if (p1point >= 3 && p2point >= 3)
                score = getScoreWhenAdvantage();

            if (p1point < 4 && p2point < 4) {
                return score;
            }

            if (Math.abs(p1point - p2point) >= 2) {
                score = "Win for " + getHigherScorePlayer();
            }
        }
        return score;
    }

    private String getScoreWhenAdvantage() {
        if (Math.abs(p1point - p2point) == 1) {
            return "Advantage " + getHigherScorePlayer();
        }
        return "";
    }

    private String initializeScore() {
        String score;
        p1res = getPlayerResult(p1point);
        p2res = getPlayerResult(p2point);
        score = p1res + "-" + p2res;
        return score;
    }

    private String getHigherScorePlayer() {
        if (p1point > p2point) {
            return "player1";
        } else {
            return "player2";
        }
    }

    private String getPlayerResult(int point) {
        if (point == 0)
            return "Love";
        if (point == 1)
            return "Fifteen";
        if (point == 2)
            return "Thirty";
        if (point == 3)
            return "Forty";
        return "";
    }

    private String scoreWhenTie(int point) {
        if (point < 3) {
            return getPlayerResult(point) + "-" + "All";
        } else {
            return "Deuce";
        }

    }

    public void setP1Score(int number) {

        for (int i = 0; i < number; i++) {
            p1Score();
        }

    }

    public void setP2Score(int number) {

        for (int i = 0; i < number; i++) {
            p2Score();
        }

    }

    private void p1Score() {
        p1point++;
    }

    private void p2Score() {
        p2point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player))
            p1Score();
        else
            p2Score();
    }
}