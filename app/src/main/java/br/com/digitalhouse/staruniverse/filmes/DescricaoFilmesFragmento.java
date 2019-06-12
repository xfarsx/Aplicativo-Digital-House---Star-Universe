package br.com.digitalhouse.staruniverse.filmes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.staruniverse.R;

public class DescricaoFilmesFragmento extends Fragment {
    public DescricaoFilmesFragmento() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos a o xml dentro de um objeto view
        View view = inflater.inflate(R.layout.activity_descricao_filmes, container, false );


        return view;
    }
}
