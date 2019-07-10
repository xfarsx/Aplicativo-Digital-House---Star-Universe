package br.com.digitalhouse.staruniverse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.Character;
import br.com.digitalhouse.staruniverse.repository.CharacterRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CharacterViewModel extends AndroidViewModel {
    private MutableLiveData<List<Character>> personagemLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private CharacterRepository repository = new CharacterRepository();

    public CharacterViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Character>> getCharacterLiveData() {
        return personagemLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }

    public void getPersonagens() {
        disposable.add(
                repository.getPersonagemApi()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(personagemResponse -> personagemLiveData.setValue(personagemResponse.getResults())
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }
}
