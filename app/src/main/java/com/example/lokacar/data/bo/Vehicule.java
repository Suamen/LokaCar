package com.example.lokacar.data.bo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "vehicules",
        foreignKeys = {
                @ForeignKey(entity = Agence.class, parentColumns = "id", childColumns = "agence_id")

        })
public class Vehicule {

    public static final String DISPO = "Disponible";
    public static final String LOUE = "Loué";
    public static final String NON_DISPO = "Indisponible";
    public static final String RESERVE = "Réservé";

    @PrimaryKey
    @NonNull
    private String immat;

    private float kilometrage;
    private String dispo;

    @ColumnInfo(name = "agence_id")
    private int agenceId;

    @Ignore
    private Agence agence;

    @Ignore
    public Vehicule() {
    }

    @Ignore
    public Vehicule(String immat) {
        this.immat = immat;
    }

    public Vehicule(@NonNull String immat, float kilometrage, String dispo, int agenceId) {
        this.immat = immat;
        this.kilometrage = kilometrage;
        this.dispo = dispo;
        this.agenceId = agenceId;
    }

    public static List<String> getListEtat(){
        List<String> listEtat = new ArrayList<>();

        listEtat.add(DISPO);
        listEtat.add(LOUE);
        listEtat.add(NON_DISPO);
        listEtat.add(RESERVE);

        return listEtat;
    }


    @NonNull
    public String getImmat() {
        return immat;
    }

    public void setImmat(@NonNull String immat) {
        this.immat = immat;
    }


    public float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(float kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(int agenceId) {
        this.agenceId = agenceId;
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
                "immat='" + immat + '\'' +
                ", kilometrage=" + kilometrage +
                ", dispo='" + dispo + '\'' +
                ", agenceId=" + agenceId +
                '}';
    }
}
