package com.myoffers.domain;

import java.sql.Time;
import java.util.Date;

public class RV {
    private Candidat candidat;
    private Offre offre;
    private Date date;
    private Time heure;

    public RV(Candidat candidat, Offre offre, Date date, Time heure) {
        this.candidat = candidat;
        this.offre = offre;
        this.date = date;
        this.heure = heure;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
}
