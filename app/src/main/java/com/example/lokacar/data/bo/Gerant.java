package com.example.lokacar.data.bo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.lokacar.data.bo.Agence;


@Entity(tableName = "gerants",
        foreignKeys = {
                @ForeignKey(entity = Agence.class, parentColumns = "id", childColumns = "agence_id")
        })
public class Gerant {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String motPasse;

    @ColumnInfo(name = "agence_id") // foreignKey
    private int agenceId;


    @Ignore
    public Gerant() {
    }

    public Gerant(String prenom, String nom, String email, String motPasse, int agenceId) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motPasse = motPasse;
        this.agenceId = agenceId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(int agenceId) {
        this.agenceId = agenceId;
    }

    @Override
    public String toString() {
        return "Gerant{" +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", agence=" + agenceId +
                '}';
    }
}
