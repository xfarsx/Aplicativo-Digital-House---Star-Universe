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
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.ViewHolder>{

    private List<Character> characterList;
    private RecyclerViewClickListener listener;
    private FavoritosDAO dao;
    private Nave naveFavorita = null;
    private Filme filmeFavorito = null;

    public PersonagemAdapter(List<Character> listaCharacter, RecyclerViewClickListener listener) {
        this.characterList = listaCharacter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recylcerview_personagens, viewGroup, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Character novoPerson = characterList.get(i);
        viewHolder.bind(novoPerson);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(novoPerson);
            }
        });

        viewHolder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                dao = Database.getDatabase(view.getContext()).favoritosDAO();
                // Se for favorito muda a imagem
                if (novoPerson.isFavorite()){
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_select);

                    new Thread(() -> {
                        dao.insert( new Favoritos(novoPerson.getName(),"Personagem" , filmeFavorito, naveFavorita, novoPerson));
                    }).start();


                }else {
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_fav_unselect);
                    new Thread(() -> {
                        dao.delete( new Favoritos(novoPerson.getName(),"Personagem" , filmeFavorito, naveFavorita, novoPerson));
                    }).start();

                }
                // configura um novo valor para o favorito
                novoPerson.setFavorite(!novoPerson.isFavorite());
            }
        });
    }

    public void update(List<Character> characterList) {
        this.characterList = characterList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private ImageView imageViewFavorite;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorita);
        }
        public void bind(Character character){

            textViewName.setText(character.getName());

        }
    }
}