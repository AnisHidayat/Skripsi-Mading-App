package com.learn.madingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mading implements Parcelable {

    int id_informasi;
    String foto;
    String judul;
    String tanggal;
    String tema;
    String konten;
    String penulis;
    String file;

    public int getId_informasi() {
        return id_informasi;
    }

    public void setId_informasi(int id_informasi) {
        this.id_informasi = id_informasi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tema) {
        this.tanggal = tanggal;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public static Creator<Mading> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeValue(this.id_informasi);
        parcel.writeString(this.foto);
        parcel.writeString(this.judul);
        parcel.writeString(this.tanggal);
        parcel.writeString(this.tema);
        parcel.writeString(this.konten);
        parcel.writeString(this.penulis);
        parcel.writeString(this.file);
    }

    public Mading() {
    }

    protected Mading(Parcel in) {
        this.id_informasi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.foto = in.readString();
        this.judul = in.readString();
        this.tanggal = in.readString();
        this.tema = in.readString();
        this.konten = in.readString();
        this.penulis = in.readString();
        this.file = in.readString();
    }

    public static final Parcelable.Creator<Mading> CREATOR = new Parcelable.Creator<Mading>() {
        @Override
        public Mading createFromParcel(Parcel source) {
            return new Mading(source);
        }

        @Override
        public Mading[] newArray(int size) {
            return new Mading[size];
        }
    };
}
