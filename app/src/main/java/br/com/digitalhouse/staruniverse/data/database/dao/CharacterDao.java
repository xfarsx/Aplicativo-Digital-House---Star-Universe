package br.com.digitalhouse.staruniverse.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.staruniverse.model.Character;
import io.reactivex.Flowable;

@Dao
public interface CharacterDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Character character);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<Character> personagens);

        @Update
        void update(Character character);

        @Query("SELECT * FROM Character limit 30")
        List<Character> getAll();

        @Query("SELECT * FROM Character limit 30")
        Flowable<List<Character>> getAllRxJava();
}