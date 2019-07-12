
package br.com.digitalhouse.staruniverse.model.filme;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity(tableName = "filmes")
public class Filme {

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
    @ColumnInfo(name = "episodeId")
    private Long episodeId;

    @Expose
    @ColumnInfo(name = "openingCrawl")
    private String openingCrawl;

    @Expose
    @ColumnInfo(name = "planets")
    private List<String> planets;

    @Expose
    @ColumnInfo(name = "producer")
    private String producer;

    @Expose
    @ColumnInfo(name = "releaseDate")
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
}
