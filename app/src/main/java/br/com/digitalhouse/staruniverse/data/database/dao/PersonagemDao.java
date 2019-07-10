package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.Personagem;
import io.reactivex.Flowable;

@Dao
public interface PersonagemDao{

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Personagem personagem);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<Personagem> personagens);

        @Update
        void update(Personagem personagem);

        @Query("SELECT * FROM personagem limit 30")
        List<Personagem> getAll();

        @Query("SELECT * FROM personagem limit 30")
        Flowable<List<Personagem>> getAllRxJava();
}