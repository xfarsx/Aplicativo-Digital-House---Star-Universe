package br.com.digitalhouse.staruniverse.personagens;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.adapter.PersonagemAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.model.PersonagemModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonagensFragment extends Fragment implements RecyclerViewClickListener {


    public PersonagensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        RecyclerView recyclerViewPerson = view.findViewById(R.id.recyclerView);
        PersonagemAdapter adapter = new PersonagemAdapter(listaDePersonagens(), this);
        recyclerViewPerson.setAdapter(adapter);
        recyclerViewPerson.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }

    @Override
    public void onClick(PersonagemModel personagemModel) {
        Intent intent = new Intent(getContext(), DetalhesPersonagensActivity.class);
        intent.putExtra("PERSONAGEM", personagemModel);
        startActivity(intent);

    }

    private List<PersonagemModel> listaDePersonagens() {
        List<PersonagemModel> personagens = new ArrayList<>();

        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)", "Darth Vader"));


        return personagens;
    }
}
