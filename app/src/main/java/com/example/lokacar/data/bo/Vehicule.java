package com.example.lokacar.data.bo;

public class Vehicule {

    private int prixLoc;
    private String type;
    private String plaqueImatriculation;
    private String status;


    public Vehicule(int prixLoc, String type, String plaqueImatriculation, String status) {
        this.prixLoc = prixLoc;
        this.type = type;
        this.plaqueImatriculation = plaqueImatriculation;
        this.status = status;
    }

    public Vehicule(String status) {
    }

    public int getPrixLoc() {
        return prixLoc;
    }

    public void setPrixLoc(int prixLoc) {
        this.prixLoc = prixLoc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaqueImatriculation() {
        return plaqueImatriculation;
    }

    public void setPlaqueImatriculation(String plaqueImatriculation) {
        this.plaqueImatriculation = plaqueImatriculation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
