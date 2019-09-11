package com.example.lokacar.data.bo;

public class Adresse {

    private int id;
    private int numero;
    private String rue;
    private int cp;
    private String ville;


    public Adresse() {

    }

    public Adresse(int id, int numero, String rue, int cp, String ville) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", cp=" + cp +
                ", ville='" + ville + '\'' +
                '}';
    }
}
