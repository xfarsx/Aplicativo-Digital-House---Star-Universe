package br.com.digitalhouse.staruniverse.view.naves;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.adapter.NavesAdapter;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerNaves;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.viewmodel.NaveViewModel;


public class NavesFragment extends Fragment implements RecyclerViewClickListenerNaves {

    private NaveViewModel viewModel;
    private List<Nave> naveList = new ArrayList<>();

    public NavesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_naves, container, false);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        RecyclerView recyclerViewNaves = view.findViewById(R.id.recycleNaves);

        // Inicializa Adapter
        NavesAdapter adapter = new NavesAdapter(naveList, this);
        recyclerViewNaves.setAdapter(adapter);
        recyclerViewNaves.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializa ViewModel
        viewModel = ViewModelProviders.of(this).get(NaveViewModel.class);
        viewModel.searchNave();

        // Adicionar os observables
        viewModel.getNaveLiveData().observe(this, naves -> adapter.update(naves));

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
            Snackbar.make(recyclerViewNaves, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }


    @Override
    public void onClick(Nave nave) {

        Intent intent = new Intent(getContext(), DetalhesNavesActivity.class);
        intent.putExtra("NAVE", nave);
        startActivity(intent);

    }
}