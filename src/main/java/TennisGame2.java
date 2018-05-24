
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
        String score = "";

        if (p1point == p2point) {
            score = scoreWhenTie();
        }

        if ((p1point == 0 || p2point == 0) && (p1point > 0 || p2point > 0)) {
            p1res = getPlayerResult(p1point);
            p2res = getPlayerResult(p2point);
            score = p1res + "-" + p2res;
        }

        if (p1point < 4) {
            if (p1point > p2point) {
                if (p1point == 2)
                    p1res = "Thirty";
                if (p1point == 3)
                    p1res = "Forty";
                if (p2point == 1)
                    p2res = "Fifteen";
                if (p2point == 2)
                    p2res = "Thirty";
                score = p1res + "-" + p2res;
            }
            if (p2point > p1point) {
                if (p2point == 2)
                    p2res = "Thirty";
                if (p2point == 3)
                    p2res = "Forty";
                if (p1point == 1)
                    p1res = "Fifteen";
                if (p1point == 2)
                    p1res = "Thirty";
                score = p1res + "-" + p2res;
            }
        }

        if (p1point > p2point && p2point >= 3) {
            score = "Advantage player1";
        }

        if (p2point > p1point && p1point >= 3) {
            score = "Advantage player2";
        }

        if (p1point >= 4 && p2point >= 0 && (p1point - p2point) >= 2) {
            score = "Win for player1";
        }
        if (p2point >= 4 && p1point >= 0 && (p2point - p1point) >= 2) {
            score = "Win for player2";
        }
        return score;
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

    private String scoreWhenTie() {
        String score = "";
        if (p1point < 4) {
            if (p1point == 0)
                score = "Love";
            if (p1point == 1)
                score = "Fifteen";
            if (p1point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (p1point >= 3)
            score = "Deuce";
        return score;
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