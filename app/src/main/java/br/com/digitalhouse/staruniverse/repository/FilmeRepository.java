package br.com.digitalhouse.staruniverse.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.FilmesDAO;
import br.com.digitalhouse.staruniverse.data.network.ApiService;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.filme.FilmeResult;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class FilmeRepository {

    public Flowable<List<Filme>> getFilmeLocal(Context context){
        Database database = Database.getDatabase(context);
        FilmesDAO filmeDao = database.filmesDAO();
        return filmeDao.getAllRxJava();
    }

    public void insertItems(Context context, List<Filme> filmes){
        Database database = Database.getDatabase(context);
        FilmesDAO filmeDao = database.filmesDAO();
        filmeDao.insertAll(filmes);
    }

    public Single<FilmeResult> getFilmeApi(){
        return ApiService.getApiService().getFilmes();
    }

}