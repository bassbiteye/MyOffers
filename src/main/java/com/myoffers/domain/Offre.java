package com.myoffers.domain;

import java.util.Date;

public class Offre {
    private int id;
    private String titre;
    private String description;
    private Date date;
    private  String type;
    private String ville;

    public Offre(int id, String titre, String description, Date date, String type, String ville) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date= date;
        this.type = type;
        this.ville = ville;
    }

    public Offre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
