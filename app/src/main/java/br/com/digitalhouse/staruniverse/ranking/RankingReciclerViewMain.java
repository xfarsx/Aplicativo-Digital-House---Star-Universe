package br.com.digitalhouse.staruniverse.ranking;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;

public class RankingReciclerViewMain extends AppCompatActivity {
    RecyclerView recyclerViewRank;
    RankingAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        recyclerViewRank = findViewById(R.id.recycleRanking);
        //Inicialização da classe adapter
        adapter = new RankingAdapter(());

        //Setando o adapter para o componente recyclerView
        recyclerViewRank.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerViewRank.setLayoutManager(new LinearLayoutManager(this));

    }
    private List<RankingActivity> listaDeContatos(){
        List<RankingActivity> ranks = new ArrayList<>();
        ranks.add(new RankingActivity("Usuário1 - 1461"));
        ranks.add(new RankingActivity("Usuário2 - 1361"));
        ranks.add(new RankingActivity("Usuário3 - 1234"));
        ranks.add(new RankingActivity("Usuário4 - 1120"));
        ranks.add(new RankingActivity("Usuário5 - 1000"));


        return ranks;
    }
}
