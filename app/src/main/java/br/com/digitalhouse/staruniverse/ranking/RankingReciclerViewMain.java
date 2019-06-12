package br.com.digitalhouse.staruniverse.ranking;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.home.HomeActivity;

public class RankingReciclerViewMain extends AppCompatActivity{
    RecyclerView recyclerViewRank;
    RankingAdapter adapter;
    private ImageView btnBack;

    public RankingReciclerViewMain() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        btnBack= findViewById(R.id.btnBackRanking);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        recyclerViewRank = findViewById(R.id.recycleRanking);
        //Inicialização da classe adapter
        adapter = new RankingAdapter(listaRanks());

        //Setando o adapter para o componente recyclerView
        recyclerViewRank.setAdapter(adapter);

        //Definição do layout da lista utilizando a classe LayoutManager
        recyclerViewRank.setLayoutManager(new LinearLayoutManager(this));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RankingReciclerViewMain.this, HomeActivity.class);
                startActivity(i);
            }
        });


    }
    private List<RankingActivity> listaRanks(){
        List<RankingActivity> ranks = new ArrayList<>();
        ranks.add(new RankingActivity("Usuário1 - 1461"));
        ranks.add(new RankingActivity("Usuário2 - 1361"));
        ranks.add(new RankingActivity("Usuário3 - 1234"));
        ranks.add(new RankingActivity("Usuário4 - 1120"));
        ranks.add(new RankingActivity("Usuário5 - 1000"));


        return ranks;
    }
}
