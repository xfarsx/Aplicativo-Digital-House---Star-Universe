
package br.com.digitalhouse.staruniverse.model.filme;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "filmes")
public class Filme implements Parcelable {

    @Expose
    @ColumnInfo(name = "characters")
    private List<String> characters;

    @Expose
    @ColumnInfo(name = "created")
    private String created;

    @Expose
    @ColumnInfo(name = "director")
    private String director;

    @Expose
    @ColumnInfo(name = "edited")
    private String edited;

    @Expose
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "episodeId")
    @SerializedName("episode_id")
    private Long episodeId;

    @Expose
    @ColumnInfo(name = "openingCrawl")
    @SerializedName("opening_crawl")
    private String openingCrawl;

    @Expose
    @ColumnInfo(name = "planets")
    private List<String> planets;

    @Expose
    @ColumnInfo(name = "producer")
    private String producer;

    @Expose
    @ColumnInfo(name = "releaseDate")
    @SerializedName("release_date")
    private String releaseDate;

    @Expose
    @ColumnInfo(name = "species")
    private List<String> species;

    @Expose
    @ColumnInfo(name = "starships")
    private List<String> starships;

    @Expose
    @ColumnInfo(name = "title")
    private String title;

    @Expose
    @ColumnInfo(name = "url")
    private String url;

    @Expose
    @ColumnInfo(name = "vehicles")
    private List<String> vehicles;

    @Expose
    @ColumnInfo(name = "favorite")
    private boolean favorite = true;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Filme() {
    }

    protected Filme(Parcel in) {
        characters = in.createStringArrayList();
        created = in.readString();
        director = in.readString();
        edited = in.readString();
        if (in.readByte() == 0) {
            episodeId = null;
        } else {
            episodeId = in.readLong();
        }
        openingCrawl = in.readString();
        planets = in.createStringArrayList();
        producer = in.readString();
        releaseDate = in.readString();
        species = in.createStringArrayList();
        starships = in.createStringArrayList();
        title = in.readString();
        url = in.readString();
        vehicles = in.createStringArrayList();
        favorite = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(characters);
        dest.writeString(created);
        dest.writeString(director);
        dest.writeString(edited);
        if (episodeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(episodeId);
        }
        dest.writeString(openingCrawl);
        dest.writeStringList(planets);
        dest.writeString(producer);
        dest.writeString(releaseDate);
        dest.writeStringList(species);
        dest.writeStringList(starships);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeStringList(vehicles);
        dest.writeByte((byte) (favorite ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Filme> CREATOR = new Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public Long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Long episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public static Creator<Filme> getCREATOR() {
        return CREATOR;
    }
}
