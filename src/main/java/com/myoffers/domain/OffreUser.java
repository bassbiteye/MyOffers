package com.myoffers.domain;

public class OffreUser {
    private Candidat candidat;
    private Offre offre;

    public OffreUser(Candidat candidat, Offre offre) {
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
