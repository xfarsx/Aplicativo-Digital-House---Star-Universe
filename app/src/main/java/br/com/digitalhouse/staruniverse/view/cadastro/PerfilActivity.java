package br.com.digitalhouse.staruniverse.view.cadastro;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.view.favoritos.FavoritosActivity;
import br.com.digitalhouse.staruniverse.view.home.HomeActivity;

public class PerfilActivity extends AppCompatActivity {

    private Button alteraEmail;
    private Button alteraSenha;
    private Button favoritos;
    private Button sair;
    private TextView user;
    private String userId, nomeJedi;
    private FirebaseAuth usuario;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private DataSnapshot dataSnapshot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

            nomeJedi = "Usuário";

        setTitle("Olá, " + nomeJedi);

        setUpToolbar();
        user = findViewById(R.id.textViewUser);
        user.setText(nomeJedi);

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
                startActivity(troca);       }
        });



        sair = findViewById(R.id.btn_sair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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
