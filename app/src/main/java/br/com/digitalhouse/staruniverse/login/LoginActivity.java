package br.com.digitalhouse.staruniverse.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.cadastro.CadastroActivity;
import br.com.digitalhouse.staruniverse.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {


    private Button buttonCadastrese;
    private Button buttonLogin;
    private Button buttonFacebook;
    private Button buttonGmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
        iniciarViews();


        botaoCadastrar();

        botaoLogin();


        botaoGmail();

        botaoFacebook();

    }

    private void botaoFacebook() {
        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(LoginActivity.this, FacebookActivity.class));
                Toast.makeText(LoginActivity.this, "View ainda em construção! Aguarde!", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void botaoGmail() {
        buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  startActivity(new Intent(LoginActivity.this,GmailActivity.class));
                Toast.makeText(LoginActivity.this, "View ainda em construção! Aguarde!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void botaoLogin() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

    private void botaoCadastrar() {
        buttonCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));

            }
        });
    }

    private void iniciarViews() {
        buttonCadastrese = findViewById(R.id.btnCadastrese);
        buttonLogin = findViewById(R.id.btnLogar);
        buttonFacebook = findViewById(R.id.btnFace);
        buttonGmail = findViewById(R.id.btnGmail);
    }


}




