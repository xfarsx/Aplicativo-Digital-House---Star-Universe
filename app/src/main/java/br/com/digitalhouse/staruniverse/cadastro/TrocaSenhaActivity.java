package br.com.digitalhouse.staruniverse.cadastro;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.home.HomeActivity;

public class TrocaSenhaActivity extends AppCompatActivity {

    private EditText editTextSenhaAntiga;
    private EditText editTextNovaSenha;
    private EditText editTextConfirmarNovaSenha;
    private Button btnConfirmarNovoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_senha);

        initViews();

        btnConfirmarNovoPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarSenha(editTextSenhaAntiga,editTextNovaSenha,editTextConfirmarNovaSenha);

            }
        });


    }

    public void validarSenha (EditText senhaA, EditText novaSenha, EditText confSenha)
    {
        if (senhaA.getText().toString().isEmpty() || novaSenha.getText().toString().isEmpty() ||
        confSenha.getText().toString().isEmpty()){
            Toast.makeText(TrocaSenhaActivity.this, "Campo não foi preenchido", Toast.LENGTH_SHORT).show();
            senhaA.requestFocus();
            return;} if (novaSenha.getText().toString().isEmpty()){
            Toast.makeText(TrocaSenhaActivity.this, "Campo não foi preenchido", Toast.LENGTH_SHORT).show();
            novaSenha.requestFocus();
            return;} if (confSenha.getText().toString().isEmpty()){
            Toast.makeText(TrocaSenhaActivity.this, "Campo não foi preenchido", Toast.LENGTH_SHORT).show();
            confSenha.requestFocus();
            return;}
        if (senhaA.getText().toString().equals(novaSenha.getText().toString()))
        {
            Toast.makeText(TrocaSenhaActivity.this, "Nova senha deve ser diferente da anterior", Toast.LENGTH_SHORT).show();
            novaSenha.requestFocus();
            return;
        }
        if(novaSenha.getText().toString().equals(123456) || novaSenha.getText().toString().length() < 6)
        {
            Toast.makeText(TrocaSenhaActivity.this, "Senhas muito fraca!", Toast.LENGTH_SHORT).show();
            novaSenha.requestFocus();
            return;
        }
        if (!novaSenha.getText().toString().equals(confSenha.getText().toString()))
        {
            Toast.makeText(TrocaSenhaActivity.this, "Senhas não são iguais!", Toast.LENGTH_SHORT).show();
            novaSenha.requestFocus();
            return;
        }
        Intent i = new Intent(TrocaSenhaActivity.this, HomeActivity.class);
        startActivity(i);
    }


    public void initViews()
    {
        btnConfirmarNovoPassword = findViewById(R.id.btnConfimarNovaSenha);
        editTextSenhaAntiga = findViewById(R.id.edtOldPassword);
        editTextNovaSenha = findViewById(R.id.edtNewPassword);
        editTextConfirmarNovaSenha = findViewById(R.id.edtNewConfPassword);
    }
}
