package com.myoffers.service.console;


import com.myoffers.domain.Candidat;
import com.myoffers.service.DisplayCandidat;

import java.util.Scanner;


public class ConsoleDisplayCandidat implements DisplayCandidat {


    public ConsoleDisplayCandidat() {
    }

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la plateforme des offres!");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 voir la liste des offres");
        System.out.println("2 my profile");
        System.out.println("3 modifier my profile");
        System.out.println("4 postuler sur une offre");
        System.out.println("5 mes offres");
        System.out.println("6 mes rv");
        System.out.println("6 je suis recruté");

    }

    @Override
    public void profile(Candidat candidat) {
        System.out.println(String.format("> %s %s %s ", candidat.getId(), candidat.getPrenom(),candidat.getNom()));

    }

    @Override
    public int[] postuler() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'offre");
        int a1=scanner.nextInt();
        System.out.println("saisir l'id du candidat");
        int a2=scanner.nextInt();
        return new int[] {a1,a2};
    }

    @Override
    public Candidat updateCandidat() {
        Candidat candidat = new Candidat();
        Scanner sc = new Scanner(System.in);
        System.out.println("saisir l'id de l'offre");
        candidat.setId(sc.nextInt());
        System.out.println("entrer la prenom");
        candidat.setPrenom(sc.next());
        System.out.println("entrer le nom");
        candidat.setNom(sc.next());
        return candidat;
    }

}



