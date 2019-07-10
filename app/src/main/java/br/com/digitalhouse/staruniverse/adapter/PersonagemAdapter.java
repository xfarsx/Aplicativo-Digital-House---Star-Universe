package br.com.digitalhouse.staruniverse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.staruniverse.model.PersonagemModel;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.ViewHolder>{

    private List<PersonagemModel> listaPersonagem;
    private RecyclerViewClickListener listener;

    public PersonagemAdapter(List<PersonagemModel> listaPersonagem, RecyclerViewClickListener listener) {
        this.listaPersonagem = listaPersonagem;
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
        final PersonagemModel novoPerson = listaPersonagem.get(i);
        viewHolder.bind(novoPerson);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(novoPerson);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPersonagem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {




        public ViewHolder(@NonNull View itemView) {
            super(itemView);



        }
        public void bind(PersonagemModel personagemAdapter){

        }
    }
}