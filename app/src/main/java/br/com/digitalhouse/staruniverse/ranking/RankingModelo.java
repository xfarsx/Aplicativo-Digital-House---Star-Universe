package br.com.digitalhouse.staruniverse.ranking;

public class RankingModelo {
    private String rankDados;

    public RankingModelo() {
    }

    public RankingModelo(String rankDados) {
        this.rankDados = rankDados;
    }

    public String getRankDados() {
        return rankDados;
    }

    public void setRankDados(String rankDados) {
        this.rankDados = rankDados;
    }
}
