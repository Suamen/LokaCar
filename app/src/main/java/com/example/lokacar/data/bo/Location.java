package com.example.lokacar.data.bo;

import java.util.Date;

public class Location {

    private Client client;
    private Vehicule vehicule;
    private Date debutLocation;
    private Date finLocation;

    public Location() {

    }

    public Location(Client client, Vehicule vehicule, Date debutLocation, Date finLocation) {
        this.client = client;
        this.vehicule = vehicule;
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
    }

    public Client getClient() {
        return client;
    }

    public void setConducteur(Client conducteur) {
        this.client = conducteur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(Date debutLocation) {
        this.debutLocation = debutLocation;
    }

    public Date getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(Date finLocation) {
        this.finLocation = finLocation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "client=" + client +
                ", vehicule=" + vehicule +
                ", debutLocation=" + debutLocation +
                ", finLocation=" + finLocation +
                '}';
    }
}
