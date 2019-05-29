package br.com.digitalhouse.staruniverse;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private TextInputEditText editNome;
    private TextInputEditText editSobreNome;
    private TextInputEditText editNomeJedi;
    private TextInputEditText editEmail;
    private TextInputEditText editSenha;
    private TextInputEditText editConfirmarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.Nome);
        editSobreNome = findViewById(R.id.SobreNome);
        editEmail = findViewById(R.id.email);
        editNomeJedi = findViewById(R.id.SobreNome);
        editSenha = findViewById(R.id.senha);
        editConfirmarSenha = findViewById(R.id.confirmar_senha);

        if (editNome.equals("")) {
            Toast.makeText(Cadastro.this, "Digite seu nome", Toast.LENGTH_SHORT).show();
            editNome.requestFocus();
            return;
        }

        if (editSobreNome.equals("")) {
            Toast.makeText(Cadastro.this, "Digite seu Sobrenome", Toast.LENGTH_SHORT).show();
            editSobreNome.requestFocus();
            return;
        }

        if (editEmail.getText().toString().contains("@") || editEmail.getText().toString().contains(".")) {
            Toast.makeText(Cadastro.this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
            editEmail.requestFocus();
            return;
        }


        if (editNomeJedi.equals("")) {
            Toast.makeText(Cadastro.this, "Digite seu nome Jedi!", Toast.LENGTH_SHORT).show();
            editNomeJedi.requestFocus();
            return;
        }


        if (editSenha.length() < 6) {
            Toast.makeText(Cadastro.this, "Sua senha não pode ser menor que 6 caracteres!", Toast.LENGTH_SHORT).show();
            editSenha.requestFocus();
            return;
        }

        if (editSenha.equals("123456")) {
            Toast.makeText(Cadastro.this, "Senha cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            editSenha.requestFocus();
            return;
        }

        if (editSenha != editConfirmarSenha) {
            Toast.makeText(Cadastro.this, "As senhas não são iguais!", Toast.LENGTH_SHORT).show();
            editConfirmarSenha.requestFocus();
            return;
        }
    }


}
