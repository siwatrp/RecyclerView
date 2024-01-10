package com.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Mhs implements Parcelable {

    String Nama ;
    String Nim ;
    String NoHP;

    public Mhs(String Nama, String Nim, String NoHP) {

        this.Nama = Nama;
        this.Nim = Nim;
        this.NoHP = NoHP;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        this.Nim = nim;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String noHP) {
        this.NoHP = noHP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nama);
        dest.writeString(this.Nim);
        dest.writeString(this.NoHP);
    }

    public void readFromParcel(Parcel source) {
        this.Nama = source.readString();
        this.Nim = source.readString();
        this.NoHP = source.readString();
    }

    protected Mhs(Parcel in) {
        this.Nama = in.readString();
        this.Nim = in.readString();
        this.NoHP = in.readString();
    }

    public static final Creator<Mhs> CREATOR = new Creator<Mhs>() {
        @Override
        public Mhs createFromParcel(Parcel source) {
            return new Mhs(source);
        }

        @Override
        public Mhs[] newArray(int size) {
            return new Mhs[size];
        }
    };
}
