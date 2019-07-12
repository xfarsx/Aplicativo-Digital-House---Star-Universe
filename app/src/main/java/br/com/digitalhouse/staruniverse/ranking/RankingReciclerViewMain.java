package br.com.digitalhouse.staruniverse.ranking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        View view = inflater.inflate(R.layout.activity_ranking, container, false);
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

    private List<RankingModelo> listaRanks() {
        List<RankingModelo> ranks = new ArrayList<>();
        ranks.add(new RankingModelo("Usuário1 - 1461"));
        ranks.add(new RankingModelo("Usuário2 - 1361"));
        ranks.add(new RankingModelo("Usuário3 - 1234"));
        ranks.add(new RankingModelo("Usuário4 - 1120"));
        ranks.add(new RankingModelo("Usuário6 - 1000"));
        ranks.add(new RankingModelo("Usuário7 - 1000"));
        ranks.add(new RankingModelo("Usuário8 - 1000"));
        ranks.add(new RankingModelo("Usuário9 - 1000"));
        ranks.add(new RankingModelo("Usuário9 - 1000"));
        ranks.add(new RankingModelo("Usuário9 - 1000"));
        ranks.add(new RankingModelo("Usuário9 - 1000"));
        ranks.add(new RankingModelo("Usuário9 - 1000"));



        return ranks;
    }
}
