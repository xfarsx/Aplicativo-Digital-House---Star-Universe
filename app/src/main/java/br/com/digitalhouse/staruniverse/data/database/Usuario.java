package br.com.digitalhouse.staruniverse.data.database;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario {

    public String usuario;
    public String email;
    public String password;


    public Usuario() {
    }

    public Usuario(String password) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    }

    public Usuario(String email,String user) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    }
}
