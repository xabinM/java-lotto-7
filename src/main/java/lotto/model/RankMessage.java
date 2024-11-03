package lotto.model;

public enum RankMessage {
    FIFTH(5, "3개 일치 (5,000원 )"),
    FOURTH(4, "4개 일치 (50,000원 )"),
    THIRD(3, "5개 일치 (1,500,000원 )"),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원 )"),
    FIRST(1, "6개 일치 (2,000,000,000원 )");

    private final int rank;
    private final String winningMessage;

    RankMessage(int rank, String winningMessage) {
        this.rank = rank;
        this.winningMessage = winningMessage;
    }

    public int getRank() {
        return rank;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
