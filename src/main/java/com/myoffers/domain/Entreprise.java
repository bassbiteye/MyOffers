package com.myoffers.domain;

public class Entreprise {
    private int id;
    private String raisonSociale;
    private String siege;
    private String numero;

    public Entreprise() {
    }

    public Entreprise(int id, String raisonSociale, String siege, String numero) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.siege = siege;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
