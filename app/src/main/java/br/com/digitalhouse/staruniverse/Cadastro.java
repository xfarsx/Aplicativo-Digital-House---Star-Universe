package br.com.digitalhouse.staruniverse;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private TextInputEditText editNome;
    private TextInputEditText editSobreNome;
    private TextInputEditText editNomeJedi;
    private TextInputEditText editEmail;
    private TextInputEditText editSenha;
    private TextInputEditText editConfirmarSenha;
    private Button buttonCadastrar;
    private Button buttoVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.Nome);
        editSobreNome = findViewById(R.id.Sobrenome);
        editEmail = findViewById(R.id.Email);
        editNomeJedi = findViewById(R.id.Jedi);
        editSenha = findViewById(R.id.Senha);
        editConfirmarSenha = findViewById(R.id.ConfirmarSenha);

        buttonCadastrar = findViewById(R.id.btnCadastro);
        buttoVoltar =findViewById(R.id.btnVoltar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (editNome.getText().toString().equals("")) {
                    Toast.makeText(Cadastro.this, "Digite seu nome", Toast.LENGTH_SHORT).show();
                    editNome.requestFocus();
                    return;
                }

                if (editSobreNome.getText().toString().equals("")) {
                    Toast.makeText(Cadastro.this, "Digite seu Sobrenome", Toast.LENGTH_SHORT).show();
                    editSobreNome.requestFocus();
                    return;
                }

                if (editEmail.getText().toString().equals("") || !editEmail.getText().toString().contains("@") || !editEmail.getText().toString().contains(".") ) {
                    Toast.makeText(Cadastro.this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
                    editEmail.requestFocus();
                    return;
                }


                if (editNomeJedi.getText().toString().equals("")) {
                    Toast.makeText(Cadastro.this, "Digite seu nome Jedi!", Toast.LENGTH_SHORT).show();
                    editNomeJedi.requestFocus();
                    return;
                }


                if (editSenha.getText().toString().length() < 6) {
                    Toast.makeText(Cadastro.this, "Sua senha não pode ser menor que 6 caracteres!", Toast.LENGTH_SHORT).show();
                    editSenha.requestFocus();
                    return;
                }

                if (editSenha.getText().toString().equals("123456")) {
                    Toast.makeText(Cadastro.this, "Senha muito fraca!", Toast.LENGTH_SHORT).show();
                    editSenha.requestFocus();
                    return;
                }

                if (!editSenha.getText().toString().equals(editConfirmarSenha.getText().toString())) {
                    Toast.makeText(Cadastro.this, "As senhas não são iguais!", Toast.LENGTH_SHORT).show();
                    editConfirmarSenha.requestFocus();
                    return;
                }

                Toast.makeText( Cadastro.this, "Usuário Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        buttoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Cadastro.this, MainActivity.class));

            }
        });

    }


}