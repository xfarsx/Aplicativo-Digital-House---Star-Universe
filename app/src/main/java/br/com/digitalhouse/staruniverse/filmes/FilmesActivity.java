package br.com.digitalhouse.staruniverse.filmes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.bottom.BottomActivity;
import br.com.digitalhouse.staruniverse.filmes.DescricaoFilmesFragmento;
import br.com.digitalhouse.staruniverse.ranking.RankingReciclerViewMain;

public class FilmesActivity extends Fragment {
    private ImageView filme1, filme2, filme3, filme4,filme5,filme6,filme7,filme8,filme9;

    public FilmesActivity() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_filmes, container, false);
    }

}



