package br.com.digitalhouse.staruniverse.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.digitalhouse.staruniverse.cadastro.Cadastro;
import br.com.digitalhouse.staruniverse.R;
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

        buttonCadastrese = findViewById(R.id.btnCadastrese);
        buttonLogin = findViewById(R.id.btnLogar);
        buttonFacebook = findViewById(R.id.btnFace);
        buttonGmail = findViewById(R.id.btnGmail);


        buttonCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, Cadastro.class));

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });


        buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  startActivity(new Intent(LoginActivity.this,Gmail.class));
                Toast.makeText(LoginActivity.this, "View ainda em construção! Aguarde!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(LoginActivity.this, Facebook.class));
                Toast.makeText(LoginActivity.this, "View ainda em construção! Aguarde!", Toast.LENGTH_SHORT).show();


            }
        });

    }


}
