package br.com.digitalhouse.staruniverse.filmes;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmesModelo implements Parcelable {


    private int image;
    private String descricao;
    private String nome;

    public FilmesModelo(String descricao, String nome) {
        this.descricao = descricao;
        this.nome = nome;
    }

    public FilmesModelo() {
    }

    protected FilmesModelo(Parcel in) {
        image = in.readInt();
        descricao = in.readString();
        nome = in.readString();
    }

    public static final Creator<FilmesModelo> CREATOR = new Creator<FilmesModelo>() {
        @Override
        public FilmesModelo createFromParcel(Parcel in) {
            return new FilmesModelo(in);
        }

        @Override
        public FilmesModelo[] newArray(int size) {
            return new FilmesModelo[size];
        }

    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(descricao);
        dest.writeString(nome);
    }
}
