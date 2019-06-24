package br.com.digitalhouse.staruniverse.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.home.HomeActivity;

public class PerfilActivity extends AppCompatActivity {

    private Button alteraEmail;
    private Button alteraSenha;
    private Button favoritos;
    private Button indiqueUmAmigo;
    private Button sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        alteraEmail = findViewById(R.id.btn_alteraremail);
        alteraEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this, "Altera e-mail", Toast.LENGTH_SHORT).show();
            }
        });

        alteraSenha = findViewById(R.id.btn_alterarsenha);
        alteraSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent troca = new Intent(PerfilActivity.this, TrocaSenhaActivity.class);
                startActivity(troca);
            }
        });

        favoritos = findViewById(R.id.btn_favoritos);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();
            }
        });

        indiqueUmAmigo = findViewById(R.id.btn_indiqueumamigo);
        indiqueUmAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this, "Indique um amigo", Toast.LENGTH_SHORT).show();
            }
        });

        sair = findViewById(R.id.btn_sair);
        alteraSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

}
