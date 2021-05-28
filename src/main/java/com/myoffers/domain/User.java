package com.myoffers.domain;

public class User {
    private int id;
    private String nom;
    private String prenom;
    private String role;
    private String login;
    private String password;
    private int tel;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String nom, String prenom, String role, String login, String password, int tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.login = login;
        this.password = password;
        this.tel = tel;
    }

    public User(int id, String nom, String prenom, String role, int tel,String login) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.tel = tel;
        this.login = login;


    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public User() {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
