package br.com.digitalhouse.staruniverse.personagens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.adapter.PersonagemAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.model.personagem.Character;
import br.com.digitalhouse.staruniverse.viewmodel.CharacterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonagensFragment extends Fragment implements RecyclerViewClickListener {

    private CharacterViewModel viewModel;
    private List<Character> characterList = new ArrayList<>();

    public PersonagensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        RecyclerView recyclerViewCharacters = view.findViewById(R.id.recyclerView);

        // Inicializa Adapter
        PersonagemAdapter adapter = new PersonagemAdapter(characterList, this);
        recyclerViewCharacters.setAdapter(adapter);
        recyclerViewCharacters.setLayoutManager(new LinearLayoutManager(getContext()));


        // Inicializa ViewModel
        viewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        viewModel.searchCharacter();

        // Adicionar os observables
        viewModel.getCharacterLiveData().observe(this, characters -> adapter.update(characters));

        //Observable Loading
        viewModel.getLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        //Observable Error
        viewModel.getErrorLiveData().observe(this, throwable -> {
            Snackbar.make(recyclerViewCharacters, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }

    @Override
    public void onClick(Character character) {
        Intent intent = new Intent(getContext(), DetalhesPersonagensActivity.class);
        intent.putExtra("PERSONAGEM", character);
        startActivity(intent);

    }
}
