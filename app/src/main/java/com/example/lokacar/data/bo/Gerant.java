package com.example.lokacar.data.bo;

public class Gerant extends Personne {

    private int id;
    private String login;
    private String mdp;

    public Gerant() {
    }

    public Gerant(int id) {
        this.id = id;
    }

    public Gerant(String nom, String prenom, Adresse adresse, String tel, String email, String login, String mdp) {
        super();
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTel(tel);
        this.setEmail(email);
        this.login = login;
        this.mdp = mdp;
    }

    public Gerant(int id, String nom, String prenom, Adresse adresse, String tel, String email) {
        super();
        this.id = id;
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTel(tel);
        this.setEmail(email);
    }

    public Gerant(int id, String nom, String prenom, Adresse adresse, String tel, String email, String login, String mdp) {
        super();
        this.id = id;
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTel(tel);
        this.setEmail(email);
        this.login = login;
        this.mdp = mdp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Gerant{"
                + "id =" + id + ", "
                + "nom = " + getNom() + ", "
                + "prenom = " + getPrenom() + ", "
                + "adresse = " + getAdresse() + ", "
                + "tél = " + getTel() + ", "
                + "email = " + getEmail() + ", "
                + "login = " + login + ", "
                + "mdp = " + mdp;
    }
}