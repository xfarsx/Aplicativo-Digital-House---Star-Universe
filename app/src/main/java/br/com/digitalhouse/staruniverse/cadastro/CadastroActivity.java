package br.com.digitalhouse.staruniverse.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.login.LoginActivity;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText editTextNomeJedi;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextSenha;
    private TextInputEditText editTextConfirmarSenha;
    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        iniciarAsViews();

        btnCadastrar = findViewById(R.id.btnCadastro);

            btnCadastrar.setOnClickListener(v -> {

                if (editTextNomeJedi.getText().toString().equals("")) {
                    Toast.makeText(CadastroActivity.this, "Digite seu nome Jedi!", Toast.LENGTH_SHORT).show();
                    editTextNomeJedi.requestFocus();
                    return;
                }
                if (editTextEmail.getText().toString().equals("") || !editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".")) {
                    Toast.makeText(CadastroActivity.this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
                    editTextEmail.requestFocus();
                    return;
                }

                if (editTextSenha.getText().toString().length() < 6) {
                    Toast.makeText(CadastroActivity.this, "Sua senha não pode ser menor que 6 caracteres!", Toast.LENGTH_SHORT).show();
                    editTextSenha.requestFocus();
                    return;
                }

                if (editTextSenha.getText().toString().equals("123456")) {
                    Toast.makeText(CadastroActivity.this, "Senha muito fraca!", Toast.LENGTH_SHORT).show();
                    editTextSenha.requestFocus();
                    return;
                }

                if (!editTextSenha.getText().toString().equals(editTextConfirmarSenha.getText().toString())) {
                    Toast.makeText(CadastroActivity.this, "As senhas não são iguais!", Toast.LENGTH_SHORT).show();
                    editTextConfirmarSenha.requestFocus();
                    return;
                }

                Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                startActivity(intent);

            });
        }


    private void iniciarAsViews() {

        editTextEmail = findViewById(R.id.Email);
        editTextNomeJedi = findViewById(R.id.Jedi);
        editTextSenha = findViewById(R.id.Senha);
        editTextConfirmarSenha = findViewById(R.id.ConfirmarSenha);
    }


}