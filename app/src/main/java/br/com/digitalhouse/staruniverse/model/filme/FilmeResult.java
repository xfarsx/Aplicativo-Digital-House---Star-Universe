
package br.com.digitalhouse.staruniverse.model.filme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.filme.Filme;

public class FilmeResult {

    @Expose
    private Long count;

    @Expose
    private Object next;

    @Expose
    private Object previous;

    @Expose
    @SerializedName("results")
    private List<Filme> filmes;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

}
