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

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizResultadoFragment extends Fragment {

    int pontuacao = 0;

    public QuizResultadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz_resultado, container, false);

        Button buttonReiniciarQuiz = view.findViewById(R.id.ButtonReiniciarQuiz);
        TextView textView = view.findViewById(R.id.textViewPontuacao);
        TextView textViewFrase = view.findViewById(R.id.frasePontuacao);

        buttonReiniciarQuiz.setOnClickListener(v->{
            ((BottomActivity)getActivity()).replaceFragment(new QuizFragment());
            pontuacao = 0;
            textViewFrase.setText("");
        });
        if (getArguments() != null) {
            //recebendo  pontuação do quiz
            pontuacao = getArguments().getInt("PONTUACAO");
            //setando informações na view
            textView.setText(Integer.toString(pontuacao));
            if (pontuacao == 0)
            {textViewFrase.setText("Você está no lado negro da força!");}
            if (pontuacao > 10 && pontuacao <= 40)
            {textViewFrase.setText("Você é um aprendiz! Continue se esforçando!");}
            if (pontuacao > 30 && pontuacao <= 80)
            {textViewFrase.setText("Você esta se esforçando, continue assim!");}
            if (pontuacao > 80 && pontuacao <= 120)
            {textViewFrase.setText("Continue assim, e logo terá resultado! ");}
            if (pontuacao > 120 && pontuacao <= 160)
            {textViewFrase.setText("Muito bem continue assim, Logo será um jedi!");}
            if (pontuacao > 160 && pontuacao < 200)
            {textViewFrase.setText("Impressionante, você está quase pronto para ser um jedi!");}
            if (pontuacao >= 200 )
            {textViewFrase.setText("Parabéns, Você literalmente é um jedi!");}

        }
        // Inflate the layout for this fragment
        return view;
    }

}
