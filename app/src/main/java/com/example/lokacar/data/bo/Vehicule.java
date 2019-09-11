package com.example.lokacar.data.bo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Vehicule implements Parcelable {

    private String immatriculation;
    private String marque;
    String photoVehicule;
    private int kilometrage;
    private boolean isLoue;
    private boolean isDisponible;
    private List<Location> locations;
    private Agence agence;

    public Vehicule() {

    }

    public Vehicule(String immatriculation, String marque, String photoVehicule, int kilometrage, boolean isLoue,
                    boolean isDisponible, List<Location> locations, Agence agence) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.photoVehicule = photoVehicule;
        this.kilometrage = kilometrage;
        this.isLoue = isLoue;
        this.isDisponible = isDisponible;
        this.locations = locations;
        this.agence = agence;
    }

    protected Vehicule(Parcel in) {
        immatriculation = in.readString();
        marque = in.readString();
        photoVehicule = in.readString();
        kilometrage = in.readInt();
        isLoue = in.readByte() != 0;
        isDisponible = in.readByte() != 0;
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getPhotoVehicule() {
        return photoVehicule;
    }

    public void setPhotoVehicule(String photoVehicule) {
        this.photoVehicule = photoVehicule;
    }

    public float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public boolean isLoue() {
        return isLoue;
    }

    public void setLoue(boolean loue) {
        isLoue = loue;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation='" + immatriculation + '\'' +
                ", marque='" + marque + '\'' +
                ", photoVehicule='" + photoVehicule + '\'' +
                ", kilometrage=" + kilometrage +
                ", isLoue=" + isLoue +
                ", isDisponible=" + isDisponible +
                ", locations=" + locations +
                ", agence=" + agence +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(immatriculation);
        parcel.writeString(marque);
        parcel.writeString(photoVehicule);
        parcel.writeInt(kilometrage);
        parcel.writeByte((byte) (isLoue ? 1 : 0));
        parcel.writeByte((byte) (isDisponible ? 1 : 0));
    }
}

