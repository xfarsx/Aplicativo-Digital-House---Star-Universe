package br.com.digitalhouse.staruniverse.cadastro;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.favoritos.FavoritosActivity;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.login.LoginActivity;

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

        setUpToolbar();
        setTitle("Olá, usuário");

        alteraEmail = findViewById(R.id.btn_alteraremail);
        alteraEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, TrocaEmailActivity.class);
                startActivity(intent);
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
               Intent troca = new Intent(PerfilActivity.this, FavoritosActivity.class);
                startActivity(troca);           }
        });

        indiqueUmAmigo = findViewById(R.id.btn_indiqueumamigo);
        indiqueUmAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PerfilActivity.this, "Indique um amigo", Toast.LENGTH_SHORT).show();
            }
        });

        sair = findViewById(R.id.btn_sair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, HomeActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
