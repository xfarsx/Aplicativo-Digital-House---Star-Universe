package br.com.digitalhouse.staruniverse.model.Favoritos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import br.com.digitalhouse.staruniverse.model.filme.Filme;
import br.com.digitalhouse.staruniverse.model.nave.Nave;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

@Entity(tableName = "favoritos")
public class Favoritos implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;


    @ColumnInfo(name = "tipoFavorito")
    private String tipoFavorito;

    @Ignore
    @ColumnInfo(name = "filmeFavorito")
    private Filme filmeFavorito;

    @Ignore
    @ColumnInfo(name = "naveFavorita")
    private Nave naveFavorita;

    @Ignore
    @ColumnInfo(name = "personagemFavorito")
    private Character personagemFavorito;

    public Favoritos() {
    }

    public Favoritos(String tipoFavorito, Filme filmeFavorito, Nave naveFavorita, Character personagemFavorito) {
        this.tipoFavorito = tipoFavorito;
        this.filmeFavorito = filmeFavorito;
        this.naveFavorita = naveFavorita;
        this.personagemFavorito = personagemFavorito;
    }

    protected Favoritos(Parcel in) {
        id = in.readLong();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        dest.writeLong(id);
        dest.writeString(tipoFavorito);
        dest.writeParcelable(filmeFavorito, flags);
        dest.writeParcelable(naveFavorita, flags);
        dest.writeParcelable(personagemFavorito, flags);
    }
}
