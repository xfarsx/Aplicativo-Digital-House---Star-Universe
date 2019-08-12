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
import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.FavoritosDAO;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerNaves;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

public class NavesAdapter extends RecyclerView.Adapter<NavesAdapter.ViewHolder> {

    private List<Nave> listaNave;
    private RecyclerViewClickListenerNaves listener;
    private FavoritosDAO dao;
    private Filme filmeFavorito = null;
    private Character personagemFavorito = null;

    public NavesAdapter(List<Nave> listaNave, RecyclerViewClickListenerNaves listener) {
        this.listaNave = listaNave;
        this.listener =  listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_naves, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Nave novaNave = listaNave.get(i);
        viewHolder.bind(novaNave);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { listener.onClick(novaNave); }
        });
            viewHolder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    dao = Database.getDatabase(view.getContext()).favoritosDAO();
                    // Se for favorito muda a imagem
                    if (novaNave.isFavorite()){
                        viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_select);

                        new Thread(() -> {
                            dao.insert( new Favoritos(novaNave.getName(),"Nave" , filmeFavorito, novaNave, personagemFavorito));
                        }).start();


                    }else {
                        viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_unselect);
                        new Thread(() -> {
                            dao.delete( new Favoritos(novaNave.getName(),"Nave" , filmeFavorito, novaNave, personagemFavorito));
                        }).start();

                    }
                    // configura um novo valor para o favorito
                    novaNave.setFavorite(!novaNave.isFavorite());
                }
            });




    }

    public void update(List<Nave> listaNave) {
        this.listaNave = listaNave;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaNave.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNaveNome;
        private ImageView imageViewFavorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNaveNome = itemView.findViewById(R.id.textViewNaveNome);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorita);
        }

        public void bind(Nave naveAdapter) {

            textViewNaveNome.setText(naveAdapter.getName());

        }
    }
}