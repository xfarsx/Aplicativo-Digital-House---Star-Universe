package br.com.digitalhouse.staruniverse.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.staruniverse.data.database.DatabaseCharacter;
import br.com.digitalhouse.staruniverse.data.database.dao.CharacterDao;
import br.com.digitalhouse.staruniverse.data.network.ApiService;
import br.com.digitalhouse.staruniverse.model.Character;
import br.com.digitalhouse.staruniverse.model.CharacterResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class CharacterRepository {
    public Flowable<List<Character>> getCharacterLocal(Context context){
        DatabaseCharacter databaseCharacter = DatabaseCharacter.getDatabase(context);
        CharacterDao characterDao = databaseCharacter.characterDao();
        return characterDao.getAllRxJava();
    }

    public void insertItems(Context context, List<Character> characters){
        DatabaseCharacter databaseCharacter = DatabaseCharacter.getDatabase(context);
        CharacterDao characterDao = databaseCharacter.characterDao();
        characterDao.insertAll(characters);
    }

    public Single<CharacterResponse> getCharacterApi(){
        return ApiService.getApiService().getCharacter();
    }

}
