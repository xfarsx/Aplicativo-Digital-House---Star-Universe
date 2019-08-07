
package br.com.digitalhouse.staruniverse.model.nave;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "naves")
public class Nave implements Parcelable {

    @SerializedName("cargo_capacity")
    private String cargoCapacity;

    @Expose
    private String consumables;

    @SerializedName("cost_in_credits")
    private String costInCredits;

    @Expose
    private String created;

    @Expose
    private String crew;

    @Expose
    private String edited;

    @Expose
    private List<String> films;

    @SerializedName("hyperdrive_rating")
    private String hyperdriveRating;

    @Expose
    private String length;

    @SerializedName("MGLT")
    private String mGLT;

    @Expose
    private String manufacturer;

    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @Expose
    private String model;

    @Expose
    private String name;

    @Expose
    private String passengers;

    @Expose
    @Ignore
    private List<Object> pilots;

    @SerializedName("starship_class")
    private String starshipClass;

    @Expose
    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Expose
    @PrimaryKey
    @NonNull
    private String url;

    public Nave() {
    }

    protected Nave(Parcel in) {
        cargoCapacity = in.readString();
        consumables = in.readString();
        costInCredits = in.readString();
        created = in.readString();
        crew = in.readString();
        edited = in.readString();
        films = in.createStringArrayList();
        hyperdriveRating = in.readString();
        length = in.readString();
        mGLT = in.readString();
        manufacturer = in.readString();
        maxAtmospheringSpeed = in.readString();
        model = in.readString();
        name = in.readString();
        passengers = in.readString();
        starshipClass = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cargoCapacity);
        dest.writeString(consumables);
        dest.writeString(costInCredits);
        dest.writeString(created);
        dest.writeString(crew);
        dest.writeString(edited);
        dest.writeStringList(films);
        dest.writeString(hyperdriveRating);
        dest.writeString(length);
        dest.writeString(mGLT);
        dest.writeString(manufacturer);
        dest.writeString(maxAtmospheringSpeed);
        dest.writeString(model);
        dest.writeString(name);
        dest.writeString(passengers);
        dest.writeString(starshipClass);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Nave> CREATOR = new Creator<Nave>() {
        @Override
        public Nave createFromParcel(Parcel in) {
            return new Nave(in);
        }

        @Override
        public Nave[] newArray(int size) {
            return new Nave[size];
        }
    };

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMGLT() {
        return mGLT;
    }

    public void setMGLT(String mGLT) {
        this.mGLT = mGLT;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public List<Object> getPilots() {
        return pilots;
    }

    public void setPilots(List<Object> pilots) {
        this.pilots = pilots;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getmGLT() {
        return mGLT;
    }

    public void setmGLT(String mGLT) {
        this.mGLT = mGLT;
    }

    public static Creator<Nave> getCREATOR() {
        return CREATOR;
    }
}
