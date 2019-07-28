package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.filme.Filme;
import io.reactivex.Flowable;

@Dao
public interface FilmesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Filme filme);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Filme> filmes);

    @Update
    void update(Filme filme);

    @Delete
    void delete(Filme filme);

    @Query("SELECT * FROM filmes")
    List<Filme> getAll();

    @Query("SELECT COUNT(episodeId) FROM filmes")
    int getCountLines();

    @Query("SELECT * FROM filmes")
    Flowable<List<Filme>> getAllRxJava();

    @Query("SELECT * FROM filmes WHERE episodeId = :episodeId")
    Filme getById(long episodeId);

    @Query("SELECT * FROM filmes WHERE title = :title")
    Filme getByName(String title);

}

