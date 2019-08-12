package br.com.digitalhouse.staruniverse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.filme.FilmeFavotito;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

        private List<FilmeFavotito> listaFilme;
        private RecyclerViewClickListenerFilmes listener;

        public FavoritosAdapter(List<FilmeFavotito> listaFilme, RecyclerViewClickListenerFilmes listener) {
            this.listaFilme = listaFilme;
            this.listener =  listener;
        }

    public FavoritosAdapter(List<FilmeFavotito> filmeFavotitos) {
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_filmes, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            ImageView imageViewFavorite;


            final FilmeFavotito novoFilme = listaFilme.get(i);
            viewHolder.bind(novoFilme);


        }

        public void update(List<FilmeFavotito> listaFilme) {
            this.listaFilme = listaFilme;
            notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {
            return listaFilme.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView textViewFilmeNome;
            private ImageView imageViewFavorite;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                textViewFilmeNome = itemView.findViewById(R.id.textViewFilmeNome);
                imageViewFavorite = itemView.findViewById(R.id.imageViewFavorita);
            }

            public void bind(FilmeFavotito filmeAdapter) {

                textViewFilmeNome.setText(filmeAdapter.getTitle());

            }
        }

}
