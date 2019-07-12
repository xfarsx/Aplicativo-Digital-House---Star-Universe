package br.com.digitalhouse.staruniverse.data.network;

import br.com.digitalhouse.staruniverse.model.CharacterResponse;
import br.com.digitalhouse.staruniverse.model.filme.FilmeResult;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("people/")
    Single<CharacterResponse> getCharacter();

    @GET("films/")
    Single<FilmeResult> getFilmes();
}
