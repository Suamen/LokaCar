package com.example.lokacar.data.bo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "agences")
class Agence {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;

    @Ignore
    public Agence() {
    }

    public Agence(String nom, String adresse, String codePostal, String ville, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
