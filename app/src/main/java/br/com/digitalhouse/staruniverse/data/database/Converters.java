package br.com.digitalhouse.staruniverse.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.staruniverse.model.Favoritos.Favoritos;
import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Favoritos fromFavoritos(String value) {
        Type listType = new TypeToken<Favoritos>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromFavoritos(Favoritos list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Filme fromFilme(String value) {
        Type listType = new TypeToken<Filme>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromFilme(Filme list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Nave fromNave(String value) {
        Type listType = new TypeToken<Nave>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromNave(Nave list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Character fromCharacter(String value) {
        Type listType = new TypeToken<Character>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCharacter(Character list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
