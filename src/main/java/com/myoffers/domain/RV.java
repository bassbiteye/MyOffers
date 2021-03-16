package com.myoffers.domain;

public class RV {
    private Offre offre;
    private String date;
    private String heure;

    public RV(Offre offre, String date, String heure) {
        this.offre = offre;
        this.date = date;
        this.heure = heure;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
