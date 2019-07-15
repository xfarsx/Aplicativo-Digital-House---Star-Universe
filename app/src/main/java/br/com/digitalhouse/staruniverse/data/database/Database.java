package br.com.digitalhouse.staruniverse.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.staruniverse.data.database.dao.CharacterDao;
import br.com.digitalhouse.staruniverse.data.database.dao.FilmesDAO;
import br.com.digitalhouse.staruniverse.data.database.dao.NavesDAO;
import br.com.digitalhouse.staruniverse.model.Character;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;

@androidx.room.Database(entities = {Filme.class, Character.class, Nave.class}, version = 6, exportSchema = false)

@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract FilmesDAO filmesDAO();
    public abstract CharacterDao characterDao();
    public abstract NavesDAO navesDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}