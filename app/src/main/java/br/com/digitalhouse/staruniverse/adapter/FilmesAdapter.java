package br.com.digitalhouse.staruniverse.adapter;

import android.icu.text.AlphabeticIndex;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.FavoritosDAO;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerFilmes;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.ViewHolder> {

    private List<Filme> listaFilme;
    private RecyclerViewClickListenerFilmes listener;
    private FavoritosDAO dao;
    private Nave naveFavorita = null;
    private Character personagemFavorito = null;



    public FilmesAdapter(List<Filme> listaFilme, RecyclerViewClickListenerFilmes listener) {
        this.listaFilme = listaFilme;
        this.listener =  listener;

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


        Filme novoFilme = listaFilme.get(i);
        viewHolder.bind(novoFilme);


        viewHolder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                dao = Database.getDatabase(view.getContext()).favoritosDAO();
                // Se for favorito muda a imagem
                if (novoFilme.isFavorite()){
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_select);

                    new Thread(() -> {
                        dao.insert( new Favoritos("Filme" , novoFilme, naveFavorita, personagemFavorito));
                    }).start();


                }else {
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_unselect);

                }
                // configura um novo valor para o favorito
                novoFilme.setFavorite(!novoFilme.isFavorite());
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(novoFilme);
            }
        });
    }

    public void update(List<Filme> listaFilme) {
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

        public void bind(Filme filmeAdapter) {

            textViewFilmeNome.setText(filmeAdapter.getTitle());

        }
    }
}