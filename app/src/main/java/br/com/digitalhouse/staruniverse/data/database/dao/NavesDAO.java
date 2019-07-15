package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.nave.Nave;
import io.reactivex.Flowable;

@Dao
public interface NavesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Nave nave);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Nave> naves);

    @Update
    void update(Nave nave);

    @Delete
    void delete(Nave nave);

    @Query("SELECT * FROM naves")
    List<Nave> getAll();

    @Query("SELECT COUNT(url) FROM naves")
    int getCountLines();

    @Query("SELECT * FROM naves")
    Flowable<List<Nave>> getAllRxJava();

    @Query("SELECT * FROM naves WHERE url = :url")
    Nave getById(String url);

}

