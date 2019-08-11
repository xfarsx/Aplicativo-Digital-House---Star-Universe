package br.com.digitalhouse.staruniverse.model.Favoritos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

@Entity(tableName = "favoritos")
public class Favoritos implements Parcelable {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "tipoFavorito")
    private String tipoFavorito;

    @ColumnInfo(name = "filmeFavorito")
    private Filme filmeFavorito;

    @ColumnInfo(name = "naveFavorita")
    private Nave naveFavorita;

    @ColumnInfo(name = "personagemFavorito")
    private Character personagemFavorito;

//    public Favoritos() {
//    }

    public Favoritos(String id, String tipoFavorito, Filme filmeFavorito, Nave naveFavorita, Character personagemFavorito) {
        this.id = id;
        this.tipoFavorito = tipoFavorito;
        this.filmeFavorito = filmeFavorito;
        this.naveFavorita = naveFavorita;
        this.personagemFavorito = personagemFavorito;
    }

    protected Favoritos(Parcel in) {
        id = in.readString();
        tipoFavorito = in.readString();
        filmeFavorito = in.readParcelable(Filme.class.getClassLoader());
        naveFavorita = in.readParcelable(Nave.class.getClassLoader());
        personagemFavorito = in.readParcelable(Character.class.getClassLoader());
    }

    public static final Creator<Favoritos> CREATOR = new Creator<Favoritos>() {
        @Override
        public Favoritos createFromParcel(Parcel in) {
            return new Favoritos(in);
        }

        @Override
        public Favoritos[] newArray(int size) {
            return new Favoritos[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoFavorito() {
        return tipoFavorito;
    }

    public void setTipoFavorito(String tipoFavorito) {
        this.tipoFavorito = tipoFavorito;
    }

    public Filme getFilmeFavorito() {
        return filmeFavorito;
    }

    public void setFilmeFavorito(Filme filmeFavorito) {
        this.filmeFavorito = filmeFavorito;
    }

    public Nave getNaveFavorita() {
        return naveFavorita;
    }

    public void setNaveFavorita(Nave naveFavorita) {
        this.naveFavorita = naveFavorita;
    }

    public Character getPersonagemFavorito() {
        return personagemFavorito;
    }

    public void setPersonagemFavorito(Character personagemFavorito) {
        this.personagemFavorito = personagemFavorito;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(tipoFavorito);
        dest.writeParcelable(filmeFavorito, flags);
        dest.writeParcelable(naveFavorita, flags);
        dest.writeParcelable(personagemFavorito, flags);
    }
}
