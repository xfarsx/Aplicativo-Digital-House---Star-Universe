package br.com.digitalhouse.staruniverse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.view.favoritos.FavoritosActivity;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private List<Favoritos> listaFavoritos;
    //private RecyclerViewClickListenerFilmes listener;


    public FavoritosAdapter(List<Favoritos> filmeFavotitos, FavoritosActivity favoritosActivity) {
        this.listaFavoritos = filmeFavotitos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_favoritos, viewGroup, true);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Favoritos novoFavorito = listaFavoritos.get(i);
        viewHolder.bind(novoFavorito);


    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public void update(List<Favoritos> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewFilmeNome;
        private TextView textViewTipoFavorito;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewFilmeNome = itemView.findViewById(R.id.textViewFavoritoNome);
            textViewTipoFavorito = itemView.findViewById(R.id.textViewTipoFavorito);
        }

        public void bind(Favoritos filmeAdapter) {

            textViewTipoFavorito.setText(filmeAdapter.getTipoFavorito());
            textViewFilmeNome.setText(filmeAdapter.getFilmeFavorito().getTitle());
        }
    }

}
