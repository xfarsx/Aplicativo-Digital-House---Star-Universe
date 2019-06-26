package br.com.digitalhouse.staruniverse.filmes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.filmes.FilmesAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.filmes.FilmesModelo;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes;

public class Filmes extends Fragment implements RecyclerViewClickListenerFilmes {


    public Filmes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filmes, container, false);
        RecyclerView recyclerViewFilmes = view.findViewById(R.id.recycleFilmes);
        FilmesAdapter adapter = new FilmesAdapter(listaDeFilmes(), (RecyclerViewClickListenerFilmes) this);
        recyclerViewFilmes.setAdapter(adapter);
        recyclerViewFilmes.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }

    private List<FilmesModelo> listaDeFilmes() {
        List<FilmesModelo> filmes = new ArrayList<>();

        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));
        filmes.add(new FilmesModelo("Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.", "Star Wars 1"));


        return filmes;
    }



    @Override
    public void onClick(FilmesModelo filmesModelo) {

        Intent intent = new Intent(getContext(), DetalhesFilmesActivity.class);
        intent.putExtra("FILME", filmesModelo);
        startActivity(intent);
    }
}
