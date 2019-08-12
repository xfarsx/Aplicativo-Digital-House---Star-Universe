package br.com.digitalhouse.staruniverse.view.quiz;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.Scene;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
    private TextView textViewPergunta, mTextField;
    private Button button;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private CountDownTimer contador;
    private Button proximaPergunta;
    private Button encerrarQuiz;
    private int numeroPerguntas = 0;



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

        proximaPergunta = view.findViewById(R.id.proximaPergunta);
        encerrarQuiz = view.findViewById(R.id.encerrarQuiz);
        buttonA = view.findViewById(R.id.ButtonAlterA);
        buttonB = view.findViewById(R.id.ButtonAlterB);
        buttonC = view.findViewById(R.id.ButtonAlterC);
        buttonD = view.findViewById(R.id.ButtonAlterD);
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
        contador();
        for (int i = 0; i < quiz.getAlternativas().size(); i++) {
            String alternativa = quiz.getAlternativas().get(i);
            Button button;
            button = alternativas.get(i);
            button.setText(alternativa);
             button.setBackgroundTintList(getResources().getColorStateList(R.color.black));
             proximaPergunta.setVisibility(View.GONE);
            encerrarQuiz.setVisibility(View.GONE);
            button.setEnabled(true);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.setEnabled(false);
                    if (button.getText().toString().equals(quiz.getResposta())) {
                        setarAcertoOuErro("certo", button);
                        buttonA.setEnabled(false);
                        buttonB.setEnabled(false);
                        buttonC.setEnabled(false);
                        buttonD.setEnabled(false);
                        gerarPontuacao();


                    } else {
                        setarAcertoOuErro("", button);
                        buttonA.setEnabled(false);
                        buttonB.setEnabled(false);
                        buttonC.setEnabled(false);
                        buttonD.setEnabled(false);

                    }
                    numeroPerguntas++;
                    if (numeroPerguntas == 5 || numeroPerguntas == 10 || numeroPerguntas == 15) {
                        encerrarQuiz.setVisibility(View.VISIBLE);
                        encerrarQuiz.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                comunicador.receberMensagem(pontuacao);
                            }
                        });
                    } else {
                        encerrarQuiz.setVisibility(View.GONE);
                    }
                    esperarProximaPergunta();

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
                proximaPergunta();

            }

        }.start();

        contador = contadorM;
    }

    public void proximaPergunta () {

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

    private void gerarPontuacao( ) {
            this.pontuacao += 10;

    }

    public void iniciarViews(View view)
    {
        textViewPergunta = view.findViewById(R.id.textViewQuizPergunta);
        mTextField = view.findViewById(R.id.contador);


    }

    public void esperarProximaPergunta()
    {
        contador.cancel();
        proximaPergunta.setVisibility(View.VISIBLE);
        proximaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaPergunta();
            }

        });
    }

    public void LayoutTransition()
    {
        Scene primeiraCena;
        Scene novaCena;


    }

     public void setarAcertoOuErro(String texto, Button button)
     {
         if (texto.equals("certo")){
         button.setBackgroundTintList(getResources().getColorStateList(R.color.rightanswered));
         button.setText("A C E R T O U!");}
         else
         {
             button.setBackgroundTintList(getResources().getColorStateList(R.color.wronganswered));
             button.setText("E R R O U!");}
         }

         public void setarAnimacao(Button button)
         {
             ObjectAnimator.ofFloat(button,"rotation",360).setDuration(500).setAutoCancel(true);
         }
     }



