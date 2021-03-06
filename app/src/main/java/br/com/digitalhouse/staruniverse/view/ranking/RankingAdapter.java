package br.com.digitalhouse.staruniverse.view.ranking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.staruniverse.R;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    private List<RankingModelo> listaDadosRank;

    public RankingAdapter(List<RankingModelo> listaDadosRank) {
        this.listaDadosRank = listaDadosRank;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view_ranking, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Criar uma nova instancia
        RankingModelo novoRank = listaDadosRank.get(i);

        //adiciona o valor da instancia para ser atribuido no componente
        viewHolder.bind(novoRank);
    }

    @Override
    public int getItemCount() {
        return listaDadosRank.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView posicaoRank;
        RelativeLayout layoutTermoRank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posicaoRank = itemView.findViewById(R.id.textoRanking);
            layoutTermoRank = itemView.findViewById(R.id.layoutItemRank);
        }

        public void bind(RankingModelo rank) {
            posicaoRank.setText(rank.getRankDados());
        }
    }
}
