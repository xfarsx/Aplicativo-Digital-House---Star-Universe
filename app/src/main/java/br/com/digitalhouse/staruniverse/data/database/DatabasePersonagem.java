package br.com.digitalhouse.staruniverse.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.staruniverse.data.database.dao.PersonagemDao;
import br.com.digitalhouse.staruniverse.model.Personagem;

@Database(entities = {Personagem.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabasePersonagem extends RoomDatabase {
    private static volatile DatabasePersonagem INSTANCE;
    public abstract PersonagemDao personagemDao();

    public static DatabasePersonagem getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DatabasePersonagem.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DatabasePersonagem.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
