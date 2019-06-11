package br.com.digitalhouse.staruniverse.ranking;

public class RankingActivity {
    private String rankDados;

    public RankingActivity() {
    }

    public RankingActivity(String rankDados) {
        this.rankDados = rankDados;
    }

    public String getRankDados() {
        return rankDados;
    }

    public void setRankDados(String rankDados) {
        this.rankDados = rankDados;
    }
}
