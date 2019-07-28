package br.com.digitalhouse.staruniverse.quiz;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import java.util.ArrayList;
import java.util.List;
import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.interfaces.QuizComunicador;
import br.com.digitalhouse.staruniverse.model.quiz.Quiz;
import br.com.digitalhouse.staruniverse.viewmodel.QuizViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {
    private QuizViewModel quizViewModel;
    private List<Quiz> perguntas = new ArrayList<>();
    private List<Button> opcoes = new ArrayList<>();
    private int qtnPerguntas;
    private int pontuacao = 0;
    private QuizComunicador comunicador;
    private TextView textViewPergunta;
    private Timer timer = new Timer();

    public QuizFragment() {
        // Required empty public constructor
    }
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicador = (QuizComunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
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
            getList(pergunta);
        });


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
                        Toast.makeText(getActivity().getApplicationContext(), "Acertou Miserave", Toast.LENGTH_SHORT).show();
                        button.setBackgroundColor(getResources().getColor(R.color.check));
                        gerarPontuacao(true);
                        proximaPergunta();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Achou errado", Toast.LENGTH_SHORT).show();
                        gerarPontuacao(false);
                        proximaPergunta();
                    }
                }
            });
        }

    }
    public void proximaPergunta() {
        if (qtnPerguntas != 0) {
            setarPergunta(perguntas.get(qtnPerguntas - 1), this.textViewPergunta, this.opcoes);
            qtnPerguntas--;
        } else {
            comunicador.receberMensagem(pontuacao);


        }

    }
    private List<Quiz> getList(List<Quiz> quiz) {
        perguntas.addAll(quiz);
        qtnPerguntas = perguntas.size();
        proximaPergunta();
        return perguntas;
    }

    private void gerarPontuacao(Boolean acerto) {
        if (acerto) {
            this.pontuacao += 10;
        } else {
            this.pontuacao -= 5;
        }
    }
}
