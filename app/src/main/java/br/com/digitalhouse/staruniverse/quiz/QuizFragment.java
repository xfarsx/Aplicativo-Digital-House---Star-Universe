package br.com.digitalhouse.staruniverse.quiz;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.quiz.Quiz;
import br.com.digitalhouse.staruniverse.viewmodel.QuizViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    private QuizViewModel quizViewModel;
    public List<Quiz> perguntas = new ArrayList<>();
    private List<Button> opcoes = new ArrayList<>();
    private int qtnPerguntas;
    public TextView textViewPergunta;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        Button btnRank = view.findViewById(R.id.btnRank);
        textViewPergunta = view.findViewById(R.id.textViewQuizPergunta);
        Button buttonA = view.findViewById(R.id.ButtonAlterA);
        Button buttonB = view.findViewById(R.id.ButtonAlterB);
        Button buttonC = view.findViewById(R.id.ButtonAlterC);
        Button buttonD = view.findViewById(R.id.ButtonAlterD);
        opcoes.add(buttonA);
        opcoes.add(buttonB);
        opcoes.add(buttonC);
        opcoes.add(buttonD);


        // Inicializa ViewModel
        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        quizViewModel.buscarPerguntas();

        // Adicionar os observables
        quizViewModel.getQuizLiveData().observe(this, pergunta -> {
            //textViewPergunta.setText(pergunta.get(0).getPergunta());
            getList(pergunta);

        });


        proximaPergunta();
        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adiconar o click para a pagina ranking do lucaa
            }
        });

        Log.i("perguntas", perguntas.toString());

        return view;
    }

    public void setarPergunta(Quiz quiz, TextView pergunta, List<Button> alternativas) {

        //setando pergunta na tela
        pergunta.setText(quiz.getPergunta());
        for (int i = 0; i < quiz.getAlternativas().size(); i++) {
            String alternativa = quiz.getAlternativas().get(i);
            Button button = alternativas.get(i);
            button.setText(alternativa);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button.getText().equals(quiz.getResposta())) {
                        Toast.makeText(getActivity().getApplicationContext(),"Acertou Miserave",Toast.LENGTH_SHORT).show();
                        proximaPergunta();
                    }else {
                        Toast.makeText(getActivity().getApplicationContext(),"Errou",Toast.LENGTH_SHORT).show();
                        proximaPergunta();
                    }
                }
            });
        }

    }

    public void proximaPergunta() {
        if (qtnPerguntas != 0) {
            setarPergunta(perguntas.get(qtnPerguntas-1), this.textViewPergunta, this.opcoes);
            qtnPerguntas--;
        } else {
            Log.i("FIM", "FIM");
        }

    }

    private List<Quiz> getList(List<Quiz> teste) {
        perguntas.addAll(teste);
        qtnPerguntas = perguntas.size();
        proximaPergunta();

        return perguntas;
    }


}
