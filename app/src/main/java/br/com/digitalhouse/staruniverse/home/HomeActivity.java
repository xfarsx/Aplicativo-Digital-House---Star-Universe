package br.com.digitalhouse.staruniverse.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.bottom.BottomActivity;
import br.com.digitalhouse.staruniverse.ranking.RankingReciclerViewMain;

public class HomeActivity extends AppCompatActivity {
   private ImageView btnFavoritos, btnPersonagens, btnQuiz, btnNoticias, btnFilmes,btnRanking;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnFavoritos = findViewById(R.id.btn_favoritos);
        btnFilmes = findViewById(R.id.btn_filmes);
        btnPersonagens = findViewById(R.id.btn_personagens);
        btnNoticias = findViewById(R.id.btn_noticias);
        btnQuiz = findViewById(R.id.btn_quiz);
        btnRanking = findViewById(R.id.btn_ranking);

        btnFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                startActivity(i);
            }
        });
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,BottomActivity.class);
                startActivity(i);
            }
        });

        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                startActivity(i);
            }
        });

        btnPersonagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                startActivity(i);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                startActivity(i);
            }
        });

        btnNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                startActivity(i);
            }
        });

    }
}
