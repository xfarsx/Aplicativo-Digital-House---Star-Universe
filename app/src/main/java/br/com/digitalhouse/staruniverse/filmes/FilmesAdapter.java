package br.com.digitalhouse.staruniverse.filmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.filmes.FilmesModelo;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.ViewHolder> {

    private List<FilmesModelo> listaFilme;
    private RecyclerViewClickListenerFilmes listener;

    public FilmesAdapter(List<FilmesModelo> listaFilme, RecyclerViewClickListenerFilmes listener) {
        this.listaFilme = listaFilme;
        this.listener =  listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_filmes, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final FilmesModelo novoFilme = listaFilme.get(i);
        viewHolder.bind(novoFilme);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(novoFilme);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFilme.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        public void bind(FilmesModelo filmesAdapter) {

        }
    }
}