package br.com.digitalhouse.staruniverse.repository;

import br.com.digitalhouse.staruniverse.data.network.ApiService;
import br.com.digitalhouse.staruniverse.model.PersonagemResponse;
import io.reactivex.Single;

public class PersonagemRepository {
    public Single<PersonagemResponse> getPersonagemApi(){
        return ApiService.getApiService().getPersonagem();
    }
}
