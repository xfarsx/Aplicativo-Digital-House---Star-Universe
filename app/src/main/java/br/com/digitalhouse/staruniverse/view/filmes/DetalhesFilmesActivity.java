package br.com.digitalhouse.staruniverse.view.filmes;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
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
        Toolbar toolbar = findViewById(R.id.toolbar);

        //Inicializa Views
        initViews();

        Filme filme = getIntent().getParcelableExtra("FILME");

        if (filme != null) {
            toolbar.setTitle(filme.getTitle());
            textViewDetalheFilmeTitle.setText(filme.getTitle());
            formatText(filme);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void formatText(Filme filme) {
        String a = textViewDetalheFilmeEpisodeId.getContext().getString(R.string.fiml_episode_id_format, String.valueOf(filme.getEpisodeId()));
        String b = textViewDetalheFilmeReleaseDate.getContext().getString(R.string.film_release_date_format, filme.getReleaseDate());
        String c = textViewDetalheFilmeCreated.getContext().getString(R.string.film_created_format, filme.getCreated());
        String d = textViewDetalheFilmeDirector.getContext().getString(R.string.film_director_format, filme.getDirector());
        String e = textViewDetalheFilmeEdited.getContext().getString(R.string.film_edited_format, filme.getEdited());
        String f = textViewDetalheFilmeOpeningCrawl.getContext().getString(R.string.film_opening_crawl_format, filme.getOpeningCrawl());
        String g = textViewDetalheFilmeProducer.getContext().getString(R.string.film_producer_format, filme.getProducer());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textViewDetalheFilmeEpisodeId.setText(Html.fromHtml(a, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeReleaseDate.setText(Html.fromHtml(b, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeCreated.setText(Html.fromHtml(c, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeDirector.setText(Html.fromHtml(d, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeEdited.setText(Html.fromHtml(e, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeOpeningCrawl.setText(Html.fromHtml(f, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheFilmeProducer.setText(Html.fromHtml(g, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textViewDetalheFilmeEpisodeId.setText(Html.fromHtml(a));
            textViewDetalheFilmeReleaseDate.setText(Html.fromHtml(b));
            textViewDetalheFilmeCreated.setText(Html.fromHtml(c));
            textViewDetalheFilmeDirector.setText(Html.fromHtml(d));
            textViewDetalheFilmeEdited.setText(Html.fromHtml(e));
            textViewDetalheFilmeOpeningCrawl.setText(Html.fromHtml(f));
            textViewDetalheFilmeProducer.setText(Html.fromHtml(g));
        }
    }

    public void initViews() {

        textViewDetalheFilmeTitle = findViewById(R.id.textViewDetalheFilmeTitle);
        imageViewImgDetalheFilme = findViewById(R.id.imageViewImgDetalheFilme);
        textViewDetalheFilmeEpisodeId = findViewById(R.id.textViewDetalheFilmeEpisodeId);
        textViewDetalheFilmeReleaseDate = findViewById(R.id.textViewDetalheFilmeReleaseDate);
        textViewDetalheFilmeCreated = findViewById(R.id.textViewDetalheFilmeCreated);
        textViewDetalheFilmeDirector = findViewById(R.id.textViewDetalheFilmeDirector);
        textViewDetalheFilmeEdited = findViewById(R.id.textViewDetalheFilmeEdited);
        textViewDetalheFilmeOpeningCrawl = findViewById(R.id.textViewDetalheFilmeOpeningCrawl);
        textViewDetalheFilmeProducer = findViewById(R.id.textViewDetalheFilmeProducer);

    }
}
