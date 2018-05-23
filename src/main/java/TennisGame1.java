
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = whenTie();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = afterIntroducingAdvantages();
        } else {
            score = beforeIntroducingAdvantages();
        }
        return score;
    }

    private String beforeIntroducingAdvantages() {
        return getScoreTitle(m_score1)
                + "-"
                + getScoreTitle(m_score2);
    }

    private String getScoreTitle(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String afterIntroducingAdvantages() {
        int scoreDifference = m_score1 - m_score2;
        return getAdvantageOrWin(scoreDifference)
                + " "
                + getHigherScoringPlayer(scoreDifference);
    }

    private String getAdvantageOrWin(int scoreDifference) {
        return Math.abs(scoreDifference) <= 1 ? "Advantage" : "Win for";
    }

    private String getHigherScoringPlayer(int scoreDifference) {
        return scoreDifference > 0 ? "player1" : "player2";
    }

    private String whenTie() {
        StringBuilder scoreBuilder = new StringBuilder();
        if (m_score1 > 2) {
            scoreBuilder.append("Deuce");
        } else {
            switch (m_score1) {
                case 0:
                    scoreBuilder.append("Love");
                    break;
                case 1:
                    scoreBuilder.append("Fifteen");
                    break;
                case 2:
                    scoreBuilder.append("Thirty");
                    break;
            }
            scoreBuilder.append("-All");
        }
        return scoreBuilder.toString();
    }
}
