package br.com.digitalhouse.staruniverse.ranking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.staruniverse.R;

public class RankingReciclerViewMain extends Fragment {
    RecyclerView recyclerViewRank;
    RankingAdapter adapter;
    private ImageView btnBack;

    public RankingReciclerViewMain() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view =  inflater.inflate(R.layout.activity_ranking, container, false);
        RecyclerView recyclerViewRanking = view.findViewById(R.id.recycleRanking);
        adapter = new RankingAdapter(listaRanks());
        recyclerViewRanking.setAdapter(adapter);
        recyclerViewRanking.setLayoutManager(new LinearLayoutManager(getActivity()));

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RankingReciclerViewMain.this, HomeActivity.class);
//                startActivity(i);
//            }
//        });
        return view;

    }
    private List<RankingActivity> listaRanks(){
        List<RankingActivity> ranks = new ArrayList<>();
        ranks.add(new RankingActivity("Usuário1 - 1461"));
        ranks.add(new RankingActivity("Usuário2 - 1361"));
        ranks.add(new RankingActivity("Usuário3 - 1234"));
        ranks.add(new RankingActivity("Usuário4 - 1120"));
        ranks.add(new RankingActivity("Usuário5 - 1000"));
        ranks.add(new RankingActivity("Usuário5 - 1000"));
        ranks.add(new RankingActivity("Usuário5 - 1000"));


        return ranks;
    }
}
