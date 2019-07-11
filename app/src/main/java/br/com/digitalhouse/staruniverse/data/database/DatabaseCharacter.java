package br.com.digitalhouse.staruniverse.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.staruniverse.data.database.dao.CharacterDao;
import br.com.digitalhouse.staruniverse.model.Character;

@Database(entities = {Character.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabaseCharacter extends RoomDatabase {
    private static volatile DatabaseCharacter INSTANCE;
    public abstract CharacterDao characterDao();

    public static DatabaseCharacter getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseCharacter.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DatabaseCharacter.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
