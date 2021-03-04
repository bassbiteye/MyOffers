package com.myoffers.domain;

public class Recruter {
    private Candidat candidat;
    private Offre offre;

    public Recruter(Candidat candidat, Offre offre) {
        this.candidat = candidat;
        this.offre = offre;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }
}