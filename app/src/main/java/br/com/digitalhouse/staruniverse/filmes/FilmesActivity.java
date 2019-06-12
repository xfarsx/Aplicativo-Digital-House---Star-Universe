package br.com.digitalhouse.staruniverse.filmes.;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.bottom.BottomActivity;
import br.com.digitalhouse.staruniverse.filmes.DescricaoFilmesFragmento;
import br.com.digitalhouse.staruniverse.ranking.RankingReciclerViewMain;

public class FilmesActivity extends AppCompatActivity {
    private ImageView filme1, filme2, filme3, filme4,filme5,filme6,filme7,filme8,filme9;

    public FilmesActivity() {
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);
        initViews();



        filme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new DescricaoFilmesFragmento());
            }
        });


    }
    private void addFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rankMain, fragment);
        transaction.addToBackStack("FRAGMENTS");
        transaction.commit();

    }
    private void initViews() {
        filme1 = findViewById(R.id.filme1);
        filme2 = findViewById(R.id.filme2);
        filme3 = findViewById(R.id.filme3);
        filme4 = findViewById(R.id.filme4);
        filme5 = findViewById(R.id.filme5);
        filme6 = findViewById(R.id.filme6);
        filme7 = findViewById(R.id.filme7);
        filme8 = findViewById(R.id.filme8);
        filme9 = findViewById(R.id.filme9);
    }
}
