package br.com.digitalhouse.staruniverse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.staruniverse.data.database.Database;
import br.com.digitalhouse.staruniverse.data.database.dao.CharacterDao;
import br.com.digitalhouse.staruniverse.model.personagem.Character;
import br.com.digitalhouse.staruniverse.model.personagem.CharacterResponse;
import br.com.digitalhouse.staruniverse.repository.CharacterRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.staruniverse.util.AppUtil.isNetworkConnected;

public class CharacterViewModel extends AndroidViewModel {
    private MutableLiveData<List<Character>> characterLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private CharacterRepository repository = new CharacterRepository();

    public CharacterViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Character>> getCharacterLiveData() {
        return characterLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }

    public void searchCharacter() {
        if (isNetworkConnected(getApplication())) {
            getApiCharacter();
        } else {
            getLocalCharacter();
        }
    }

    private void getLocalCharacter() {
        disposable.add(
                repository.getCharacterLocal(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(characters -> characterLiveData.setValue(characters)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private void getApiCharacter() {
        disposable.add(
                repository.getCharacterApi()
                        .subscribeOn(Schedulers.newThread())
                        .map(characterResponse -> saveItems(characterResponse))
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(characterResponse -> characterLiveData.setValue(characterResponse.getResults())
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private CharacterResponse saveItems(CharacterResponse characterResponse) {
        CharacterDao characterDao = Database.getDatabase(getApplication()
                .getApplicationContext())
                .characterDao();

        characterDao.insertAll(characterResponse.getResults());
        return characterResponse;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}