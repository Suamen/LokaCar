package com.example.lokacar.data.bo;

import java.util.List;

public class Client extends Personne {

    private int id;
    private List<Location> locations;

    public Client() {

    }

    public Client(int id, List<Location> locations) {
        this.id = id;
        this.locations = locations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Conducteur{" +
                "id=" + id +
                ", locations=" + locations +
                '}';
    }
}