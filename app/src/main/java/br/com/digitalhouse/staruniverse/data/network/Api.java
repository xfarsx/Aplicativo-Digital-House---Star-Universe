package br.com.digitalhouse.staruniverse.data.network;

import br.com.digitalhouse.staruniverse.model.personagem.CharacterResponse;
import br.com.digitalhouse.staruniverse.model.filme.FilmeResult;
import br.com.digitalhouse.staruniverse.model.nave.NaveResult;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {
    @GET("people/")
    Single<CharacterResponse> getCharacter();

    @GET("films/")
    Single<FilmeResult> getFilmes();

    @GET("starships/")
    Single<NaveResult> getNaves();

}
