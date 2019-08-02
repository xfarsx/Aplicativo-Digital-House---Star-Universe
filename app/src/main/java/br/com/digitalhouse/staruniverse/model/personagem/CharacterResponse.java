
package br.com.digitalhouse.staruniverse.model.personagem;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class CharacterResponse {

    @Expose
    private Long count;
    @Expose
    private String next;
    @Expose
    private Object previous;
    @Expose
    private List<Character> results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

}
