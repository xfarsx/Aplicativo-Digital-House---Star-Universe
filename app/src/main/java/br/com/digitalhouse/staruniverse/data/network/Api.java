package br.com.digitalhouse.staruniverse.data.network;

import br.com.digitalhouse.staruniverse.model.CharacterResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("people/")
    Single<CharacterResponse> getPersonagem();
}
