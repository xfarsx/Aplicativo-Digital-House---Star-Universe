package br.com.digitalhouse.staruniverse.data.network;

import br.com.digitalhouse.staruniverse.model.PersonagemResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("people/")
    Single<PersonagemResponse> getPersonagem();
}
