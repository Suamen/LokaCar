package com.example.lokacar.data.bo;

import java.util.List;

public class Agence {

    private int id;
    private String nomAgence;
    private Adresse adresse;
    private Gerant gerant;
    private List<Vehicule> listVehicule;

    public Agence() {
    }

    public Agence(String nomAgence, Adresse adresse, Gerant gerant) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.gerant = gerant;
    }

    public Agence(String nomAgence, Adresse adresse, Gerant gerant, List<Vehicule> listVehicule) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.gerant = gerant;
        this.listVehicule = listVehicule;
    }

    public Agence(int id, String nomAgence, Adresse adresse, Gerant gerant) {
        this.id = id;
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.gerant = gerant;
    }

    public Agence(int id, String nomAgence, Adresse adresse, Gerant gerant, List<Vehicule> listVehicule) {
        this.id = id;
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.gerant = gerant;
        this.listVehicule = listVehicule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public List<Vehicule> getListVehicule() {
        return listVehicule;
    }

    public void setListVehicule(List<Vehicule> listVehicule) {
        this.listVehicule = listVehicule;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "adresse=" + adresse +
                ", nomAgence='" + nomAgence + '\'' +
                ", gerant=" + gerant +
                ", listVehicule=" + listVehicule +
                '}';
    }
}
