package br.com.digitalhouse.staruniverse.model.usuarios;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import br.com.digitalhouse.staruniverse.view.cadastro.validadorFirebase.ValidarFirebase;

public class CadastroUsuario {

    private String email;
    private String nomeJedi;
    private String senha;
    private String id;

    public CadastroUsuario() {
    }

    public CadastroUsuario(String nome, String sobrenome, String email, String nomeJedi, String senha, String confirmarSenha, String id) {
        this.email = email;
        this.nomeJedi = nomeJedi;
        this.senha = senha;
        this.id = id;
    }

    public void salvar() {

        DatabaseReference referenceDatabase = ValidarFirebase.getFirebase();
        referenceDatabase.child("usuario").child(getId()).setValue(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeJedi() {
        return nomeJedi;
    }

    public void setNomeJedi(String nomeJedi) {
        this.nomeJedi = nomeJedi;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
