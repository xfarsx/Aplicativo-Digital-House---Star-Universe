package br.com.digitalhouse.staruniverse.model.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {
    @Expose
    @SerializedName("titulo")
    private String pergunta;
    @Expose
    @SerializedName("resposta")
    private String resposta;
    @Expose
    @SerializedName("alternativas")
    private List<String> alternativas;

    public Quiz() {
    }

    public Quiz(String pergunta, String resposta, List<String> alternativas) {

        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativas = alternativas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }
}
