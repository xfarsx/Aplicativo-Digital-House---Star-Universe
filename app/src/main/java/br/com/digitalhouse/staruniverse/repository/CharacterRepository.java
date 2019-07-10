package br.com.digitalhouse.staruniverse.repository;

import br.com.digitalhouse.staruniverse.data.network.ApiService;
import br.com.digitalhouse.staruniverse.model.CharacterResponse;
import io.reactivex.Single;

public class CharacterRepository {
    public Single<CharacterResponse> getPersonagemApi(){
        return ApiService.getApiService().getPersonagem();
    }
}
