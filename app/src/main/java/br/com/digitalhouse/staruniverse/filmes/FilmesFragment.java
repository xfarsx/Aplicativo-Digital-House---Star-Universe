package br.com.digitalhouse.staruniverse.filmes;

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
import br.com.digitalhouse.staruniverse.adapter.FilmesAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.viewmodel.FilmeViewModel;

public class FilmesFragment extends Fragment implements RecyclerViewClickListenerFilmes {

    private FilmeViewModel viewModel;
    private List<Filme> filmeList = new ArrayList<>();


    public FilmesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filmes, container, false);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        RecyclerView recyclerViewFilmes = view.findViewById(R.id.recycleFilmes);

        // Inicializa Adapter
        FilmesAdapter adapter = new FilmesAdapter(filmeList, this);
        recyclerViewFilmes.setAdapter(adapter);
        recyclerViewFilmes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializa ViewModel
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);
        viewModel.searchFilme();

        // Adicionar os observables
        viewModel.getFilmeLiveData().observe(this, filmes -> adapter.update(filmes));

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
            Snackbar.make(recyclerViewFilmes, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }

    @Override
    public void onClick(Filme filme) {

        Intent intent = new Intent(getContext(), DetalhesFilmesActivity.class);
        intent.putExtra("FILME", filme);
        startActivity(intent);

    }
}
