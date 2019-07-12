package br.com.digitalhouse.staruniverse.filmes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.filme.Filme;

public class DetalhesFilmesActivity extends AppCompatActivity {

    private TextView textViewDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_filmes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        textViewDescricao = findViewById(R.id.textViewDescricaoFilme);

        Filme filme = getIntent().getParcelableExtra("FILME");

        if (filme != null) {
            textViewDescricao.setText(filme.getTitle());
            toolbar.setTitle(filme.getTitle());
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
