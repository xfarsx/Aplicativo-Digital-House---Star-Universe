package br.com.digitalhouse.staruniverse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


import br.com.digitalhouse.staruniverse.model.quiz.Quiz;
import br.com.digitalhouse.staruniverse.repository.QuizRepository;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class QuizViewModel extends AndroidViewModel {
    private MutableLiveData<List<Quiz>> quizLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private QuizRepository repository = new QuizRepository();

    public QuizViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Quiz>> getQuizLiveData() {
        return quizLiveData;
    }
    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }


    public void buscarPerguntas() {

        /*if (AppUtil.isNetworkConnected(getApplication().getApplicationContext())){
        }*/

        disposable.add(


                        repository.obterListaPerguntasDoArquivo(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(quizResposta -> {
                            quizLiveData.setValue(quizResposta.getPerguntas());
                        }, throwable -> {
                            errorLiveData.setValue(throwable);
                        })

        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
