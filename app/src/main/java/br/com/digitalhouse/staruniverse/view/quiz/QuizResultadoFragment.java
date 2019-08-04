package br.com.digitalhouse.staruniverse.view.quiz;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.view.bottom.BottomActivity;
import br.com.digitalhouse.staruniverse.view.ranking.RankingReciclerViewMain;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizResultadoFragment extends Fragment {


    public QuizResultadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz_resultado, container, false);

        Button buttonReiniciarQuiz = view.findViewById(R.id.ButtonReiniciarQuiz);
        Button buttonRanking = view.findViewById(R.id.ButtonRanking);
        TextView textView = view.findViewById(R.id.textViewPontuacao);

        buttonRanking.setOnClickListener(v-> {
            ((BottomActivity)getActivity()).replaceFragment(new RankingReciclerViewMain());

        });
        buttonReiniciarQuiz.setOnClickListener(v->{
            ((BottomActivity)getActivity()).replaceFragment(new QuizFragment());
        });
        if (getArguments() != null) {
            //recebendo  pontuação do quiz
            int pontuacao = getArguments().getInt("PONTUACAO");
            //setando informações na view
            textView.setText(Integer.toString(pontuacao));
        }
        // Inflate the layout for this fragment
        return view;
    }

}
