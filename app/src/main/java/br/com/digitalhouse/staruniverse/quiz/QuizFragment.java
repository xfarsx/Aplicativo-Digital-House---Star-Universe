package br.com.digitalhouse.staruniverse.quiz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import java.util.TimerTask;

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
    private TextView textViewPergunta, mTextField;
    private Button button;
    private CountDownTimer contador;


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
        iniciarViews(view);
        opcoes.add(view.findViewById(R.id.ButtonAlterA));
        opcoes.add(view.findViewById(R.id.ButtonAlterB));
        opcoes.add(view.findViewById(R.id.ButtonAlterC));
        opcoes.add(view.findViewById(R.id.ButtonAlterD));

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
        contador();
        for (int i = 0; i < quiz.getAlternativas().size(); i++) {
            String alternativa = quiz.getAlternativas().get(i);
            Button button;
            button = alternativas.get(i);
            button.setText(alternativa);
           button.setBackgroundTintList(getResources().getColorStateList(R.color.black));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button.getText().toString().equals(quiz.getResposta())) {
                      /*  if (button.findViewById(R.id.ButtonAlterA).isPressed()){
                        button.findViewById(R.id.ButtonAlterA).setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));}
                        if (button.findViewById(R.id.ButtonAlterB).isPressed()){
                            button.findViewById(R.id.ButtonAlterB).setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));}
                        if (button.findViewById(R.id.ButtonAlterC).isPressed()){
                            button.findViewById(R.id.ButtonAlterC).setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));}
                        if (button.findViewById(R.id.ButtonAlterD).isPressed()){
                            button.findViewById(R.id.ButtonAlterD).setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));}
                      */  contador.cancel();
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                proximaPergunta();
                         if (button.findViewById(R.id.ButtonAlterA).isPressed()){
                        button.findViewById(R.id.ButtonAlterA).setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));}
                            }
                        },2000);
                        if(timer !=null)
                        {
                            timer.cancel();
                        }
                        gerarPontuacao(true);

                    } else {
                        button.setBackgroundTintList(getResources().getColorStateList(R.color.wronganswered));
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                proximaPergunta();
                            }
                        },2000);
                        if(timer !=null)
                        {
                            timer.cancel();
                        }
                        contador.cancel();
                        proximaPergunta();
                        gerarPontuacao(true);

                    }
                }
            });
        }


    }
    public void contador()
    {

        CountDownTimer contadorM = new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                    mTextField.setText("");
                proximaPergunta();

            }

        }.start();

        contador = contadorM;
    }

    public void proximaPergunta ( ) {
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

    public void iniciarViews(View view)
    {
        textViewPergunta = view.findViewById(R.id.textViewQuizPergunta);
        mTextField = view.findViewById(R.id.contador);
    }
}
