package br.com.digitalhouse.staruniverse.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.NavesDAO;
import br.com.digitalhouse.staruniverse.data.network.ApiService;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.nave.NaveResult;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class NaveRepository {
    public Flowable<List<Nave>> getNaveLocal(Context context) {
        Database database = Database.getDatabase(context);
        NavesDAO navesDao = database.navesDao();
        return navesDao.getAllRxJava();
    }

    public void insertItems(Context context, List<Nave> naves) {
        Database database = Database.getDatabase(context);
        NavesDAO navesDao = database.navesDao();
        navesDao.insertAll(naves);
    }

    public Single<NaveResult> getNaveApi() {
        return ApiService.getApiService().getNaves();
    }

}