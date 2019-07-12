
package br.com.digitalhouse.staruniverse.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")

@Entity(tableName = "character")
public class Character implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long idPersonagem;
    @SerializedName("birth_year")
    private String birthYear;
    @Expose
    private String created;
    @Expose
    private String edited;
    @SerializedName("eye_color")
    private String eyeColor;
    @Expose
    private List<String> films;
    @Expose
    private String gender;
    @SerializedName("hair_color")
    private String hairColor;
    @Expose
    private String height;
    @Expose
    private String homeworld;
    @Expose
    private String mass;
    @Expose
    private String name;
    @SerializedName("skin_color")
    private String skinColor;
    @Expose
    private List<String> species;
    @Expose
    private List<String> starships;
    @Expose
    private String url;
    @Expose
    private List<String> vehicles;

    public Character() {
    }

    protected Character(Parcel in) {
        idPersonagem = in.readLong();
        birthYear = in.readString();
        created = in.readString();
        edited = in.readString();
        eyeColor = in.readString();
        films = in.createStringArrayList();
        gender = in.readString();
        hairColor = in.readString();
        height = in.readString();
        homeworld = in.readString();
        mass = in.readString();
        name = in.readString();
        skinColor = in.readString();
        species = in.createStringArrayList();
        starships = in.createStringArrayList();
        url = in.readString();
        vehicles = in.createStringArrayList();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long idPersonagem) {
        this.idPersonagem = idPersonagem;
    }


    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idPersonagem);
        dest.writeString(birthYear);
        dest.writeString(created);
        dest.writeString(edited);
        dest.writeString(eyeColor);
        dest.writeStringList(films);
        dest.writeString(gender);
        dest.writeString(hairColor);
        dest.writeString(height);
        dest.writeString(homeworld);
        dest.writeString(mass);
        dest.writeString(name);
        dest.writeString(skinColor);
        dest.writeStringList(species);
        dest.writeStringList(starships);
        dest.writeString(url);
        dest.writeStringList(vehicles);
    }
}
