package br.com.digitalhouse.staruniverse.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.digitalhouse.staruniverse.model.quiz.QuizResposta;
import io.reactivex.Single;

public class QuizRepository {
    public Single<QuizResposta> obterListaPerguntasDoArquivo(Context context) {
        try {
            AssetManager manager = context.getAssets();
            InputStream newJson = manager.open("Perguntas.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            QuizResposta resposta = gson.fromJson(reader, QuizResposta.class);

            return Single.just(resposta);

        } catch (IOException e) {
            e.printStackTrace();
            return Single.error(e);
        }
    }

}
