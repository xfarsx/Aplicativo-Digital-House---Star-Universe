package br.com.digitalhouse.staruniverse.filmes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.filme.Filme;

public class DetalhesFilmesActivity extends AppCompatActivity {

    private ImageView imageViewImgDetalheFilme;
    private TextView textViewDetalheFilmeEpisodeId;
    private TextView textViewDetalheFilmeTitle;
    private TextView textViewDetalheFilmeReleaseDate;
    private TextView textViewDetalheFilmeCreated;
    private TextView textViewDetalheFilmeDirector;
    private TextView textViewDetalheFilmeEdited;
    private TextView textViewDetalheFilmeOpeningCrawl;
    private TextView textViewDetalheFilmeProducer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_filmes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Inicializa Views
        initViews();

        Filme filme = getIntent().getParcelableExtra("FILME");

        if (filme != null) {
            toolbar.setTitle(filme.getTitle());

            textViewDetalheFilmeEpisodeId.setText(filme.getEpisodeId().toString());
            textViewDetalheFilmeTitle.setText(filme.getTitle());
            textViewDetalheFilmeReleaseDate.setText(filme.getReleaseDate());
            textViewDetalheFilmeCreated.setText(filme.getCreated());
            textViewDetalheFilmeDirector.setText(filme.getDirector());
            textViewDetalheFilmeEdited.setText(filme.getEdited());
            textViewDetalheFilmeOpeningCrawl.setText(filme.getOpeningCrawl());
            textViewDetalheFilmeProducer.setText(filme.getProducer());

        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void initViews() {

        imageViewImgDetalheFilme = findViewById(R.id.imageViewImgDetalheFilme);
        textViewDetalheFilmeEpisodeId = findViewById(R.id.textViewDetalheFilmeEpisodeId);
        textViewDetalheFilmeTitle = findViewById(R.id.textViewDetalheFilmeTitle);
        textViewDetalheFilmeReleaseDate = findViewById(R.id.textViewDetalheFilmeReleaseDate);
        textViewDetalheFilmeCreated = findViewById(R.id.textViewDetalheFilmeCreated);
        textViewDetalheFilmeDirector = findViewById(R.id.textViewDetalheFilmeDirector);
        textViewDetalheFilmeEdited = findViewById(R.id.textViewDetalheFilmeEdited);
        textViewDetalheFilmeOpeningCrawl = findViewById(R.id.textViewDetalheFilmeOpeningCrawl);
        textViewDetalheFilmeProducer = findViewById(R.id.textViewDetalheFilmeProducer);

    }
}
