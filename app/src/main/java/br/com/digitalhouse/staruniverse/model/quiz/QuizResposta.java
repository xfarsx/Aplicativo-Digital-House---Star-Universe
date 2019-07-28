package br.com.digitalhouse.staruniverse.model.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizResposta {
    @Expose
    @SerializedName("perguntas")
    private List<Quiz> perguntas;

    public List<Quiz> getPerguntas() {
        return perguntas;
    }

    public void setNoticias(List<Quiz> perguntas) {
        this.perguntas = perguntas;
    }
}
