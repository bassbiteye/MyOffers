package com.myoffers.domain;

public class Recruter {
    private Offre offre;

    public Recruter(Offre offre) {
        this.offre = offre;
    }



    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }
}
