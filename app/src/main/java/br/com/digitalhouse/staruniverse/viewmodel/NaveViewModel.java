package br.com.digitalhouse.staruniverse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.NavesDAO;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.nave.NaveResult;
import br.com.digitalhouse.staruniverse.repository.NaveRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.staruniverse.util.AppUtil.isNetworkConnected;

public class NaveViewModel extends AndroidViewModel {

    private MutableLiveData<List<Nave>> naveLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private NaveRepository repository = new NaveRepository();

    public NaveViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Nave>> getNaveLiveData() {
        return naveLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }

    public void searchNave() {
        if (isNetworkConnected(getApplication())) {
            getApiNave();
        } else {
            getLocalNave();
        }
    }

    private void getLocalNave() {
        disposable.add(
                repository.getNaveLocal(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(naves -> naveLiveData.setValue(naves)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private void getApiNave() {
        disposable.add(
                repository.getNaveApi()
                        .subscribeOn(Schedulers.newThread())
                        .map(naveResult -> saveItems(naveResult))
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(naveResult -> naveLiveData.setValue(naveResult.getNaves())
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private NaveResult saveItems(NaveResult naveResult) {
        NavesDAO navesDao = Database.getDatabase(getApplication()
                .getApplicationContext())
                .navesDao();

        navesDao.insertAll(naveResult.getNaves());
        return naveResult;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}