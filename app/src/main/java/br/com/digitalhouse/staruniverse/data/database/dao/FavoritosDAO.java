package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import io.reactivex.Flowable;

@Dao
public interface FavoritosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favoritos favoritos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Favoritos> favoritos);

    @Update
    void update(Favoritos favoritos);

    @Delete
    void delete(Favoritos favoritos);

    @Query("SELECT * FROM favoritos")
    List<Favoritos> getAll();

    @Query("SELECT COUNT(id) FROM favoritos")
    int getCountLines();

    @Query("SELECT * FROM favoritos")
    Flowable<List<Favoritos>> getAllRxJava();

    @Query("SELECT * FROM favoritos WHERE id = :id")
    Favoritos getById(long id);

    @Query("SELECT * FROM favoritos WHERE tipoFavorito = :tipoFavorito")
    Favoritos getByName(String tipoFavorito);
}
