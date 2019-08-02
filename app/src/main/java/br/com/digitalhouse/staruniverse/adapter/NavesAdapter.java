package br.com.digitalhouse.staruniverse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.interfaces.RecyclerViewClickListenerNaves;
import br.com.digitalhouse.staruniverse.model.nave.Nave;

public class NavesAdapter extends RecyclerView.Adapter<NavesAdapter.ViewHolder> {

    private List<Nave> listaNave;
    private RecyclerViewClickListenerNaves listener;

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
            public void onClick(View view) {
                listener.onClick(novaNave);
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNaveNome = itemView.findViewById(R.id.textViewNaveNome);
        }

        public void bind(Nave naveAdapter) {

            textViewNaveNome.setText(naveAdapter.getName());

        }
    }
}