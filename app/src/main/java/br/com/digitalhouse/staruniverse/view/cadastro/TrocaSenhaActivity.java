package br.com.digitalhouse.staruniverse.view.cadastro;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.view.home.HomeActivity;

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
           sUToastShort ("Campo não foi preenchido", 16);
            senhaA.requestFocus();
            return;} if (novaSenha.getText().toString().isEmpty()){
           sUToastShort ("Campo não foi preenchido", 16);
            novaSenha.requestFocus();
            return;} if (confSenha.getText().toString().isEmpty()){
           sUToastShort ("Campo não foi preenchido" , 16);
            confSenha.requestFocus();
            return;}
        if (senhaA.getText().toString().equals(novaSenha.getText().toString()))
        {
           sUToastShort ("Nova senha deve ser diferente da anterior" , 16);
            novaSenha.requestFocus();
            return;
        }
        if(novaSenha.getText().toString().equals(123456) || novaSenha.getText().toString().length() < 6)
        {
           sUToastShort ("Senhas muito fraca!" , 16);
            novaSenha.requestFocus();
            return;
        }
        if (!novaSenha.getText().toString().equals(confSenha.getText().toString()))
        {
           sUToastShort ("Senhas não são iguais!" , 16);
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
    public void sUToastShort (String texto, float tamanho)  {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toas_layout,
                findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText(texto);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 12, 120);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }


}
