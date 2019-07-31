package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.filme.FilmeFavotito;
import io.reactivex.Flowable;

@Dao
public interface FilmeFavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FilmeFavotito filme);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FilmeFavotito> filmes);

    @Update
    void update(FilmeFavotito filme);

    @Delete
    void delete(FilmeFavotito filme);

    @Query("SELECT * FROM filmes")
    List<FilmeFavotito> getAll();

    @Query("SELECT COUNT(episodeId) FROM filmes")
    int getCountLines();

    @Query("SELECT * FROM filmes")
    Flowable<List<FilmeFavotito>> getAllRxJava();

    @Query("SELECT * FROM filmes WHERE episodeId = :episodeId")
    Filme getById(long episodeId);

    @Query("SELECT * FROM filmes WHERE title = :title")
    Filme getByName(String title);

}
