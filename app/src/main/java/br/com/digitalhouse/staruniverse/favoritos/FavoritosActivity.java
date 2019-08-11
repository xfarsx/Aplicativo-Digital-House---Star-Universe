package br.com.digitalhouse.staruniverse.favoritos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.adapter.FavoritosAdapter;
import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.FavoritosDAO;
import br.com.digitalhouse.staruniverse.filmes.DetalhesFilmesActivity;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes1;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import br.com.digitalhouse.staruniverse.naves.DetalhesNavesActivity;
import br.com.digitalhouse.staruniverse.personagens.DetalhesPersonagensActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FavoritosActivity extends AppCompatActivity implements RecyclerViewClickListenerFilmes1 {

    private RecyclerView recyclerView;
    private List<Favoritos> filmeFavotitos = new ArrayList<>();
    private FavoritosAdapter adapter;
    private FavoritosDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setUpToolbar();
        setTitle("Favoritos");


        recyclerView = findViewById(R.id.recycleFavoritos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new FavoritosAdapter(filmeFavotitos, this);

        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

        dao = Database.getDatabase(this).favoritosDAO();

        buscarTodosOsFilmes();

    }

    private void buscarTodosOsFilmes() {
        dao.getAllRxJava()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(filmeFavoritos2 -> {
                    adapter.update(filmeFavoritos2);
                }, throwable -> Log.i("TAG", "buscarTodosOsFilmesFavoritos: " + throwable.getMessage()));
    }


    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
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
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(Favoritos favoritos) {
        if (favoritos.getTipoFavorito().equals("Filme")) {
            Intent intent = new Intent(this, DetalhesFilmesActivity.class);
            intent.putExtra("FILME", favoritos.getFilmeFavorito());
            startActivity(intent);
        }
        if (favoritos.getTipoFavorito().equals("Nave")) {
            Intent intent = new Intent(this, DetalhesNavesActivity.class);
            intent.putExtra("NAVE", favoritos.getNaveFavorita());
            startActivity(intent);
        }
        if (favoritos.getTipoFavorito().equals("Personagem")) {
            Intent intent = new Intent(this, DetalhesPersonagensActivity.class);
            intent.putExtra("PERSONAGEM", favoritos.getPersonagemFavorito());
            startActivity(intent);
        }

    }
}
