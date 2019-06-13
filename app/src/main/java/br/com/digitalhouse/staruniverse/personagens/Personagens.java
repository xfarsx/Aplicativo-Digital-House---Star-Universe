package br.com.digitalhouse.staruniverse.personagens;


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
import br.com.digitalhouse.staruniverse.adapter.PersonagemAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.model.PersonagemModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Personagens extends Fragment implements RecyclerViewClickListener {



    public Personagens() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_characters, container, false);
        RecyclerView recyclerViewPerson = view.findViewById(R.id.recyclerView);
        PersonagemAdapter adapter =  new PersonagemAdapter(listaDePersons(), this);
        recyclerViewPerson.setAdapter(adapter);
        recyclerViewPerson.setLayoutManager(new GridLayoutManager(getContext(),3));
        return view;
    }
    private List<PersonagemModel> listaDePersons(){
        List<PersonagemModel> personagens = new ArrayList<>();

        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));
        personagens.add(new PersonagemModel("Darth Vader, nascido como Anakin Skywalker, é o protagonista da trilogia prequela e antagonista da trilogia original da série de filmes Star Wars (Guerra nas Estrelas)","Darth Vader"));


        return personagens;
    }

    @Override
    public void onClick(PersonagemModel personagemModel) {

        Intent intent = new Intent(getContext(), DetalhesPersonagensActivity.class);
        intent.putExtra("PERSONAGEM",personagemModel);
        startActivity(intent);
    }
}
