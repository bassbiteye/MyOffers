package com.myoffers.service.console;


import com.myoffers.domain.Offre;
import com.myoffers.service.DisplayOffre;

import java.util.Scanner;

public class ConsoleDisplayOffre implements DisplayOffre {


    public ConsoleDisplayOffre() {
    }

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la plateforme des offres!");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 lister les offres");
        System.out.println("2 ajouter une offre");
        System.out.println("3 modifier une offre");
        System.out.println("4 supprimer une offre");
        System.out.println("5 selectionner un candidat");
        System.out.println("6 donner rv");
        System.out.println("7 recruter un candidat");

    }

    @Override
    public void afficherListeOffres(Offre[] offres) {
        System.out.println("Les offres disponibles sont:");
        for (int i = 0; i < offres.length; i++) {
            Offre offre = offres[i];
            System.out.println(String.format("> %s %s %s %s %s %s", offre.getId(), offre.getTitre(),offre.getDescription(),offre.getDate(),offre.getVille(),offre.getType()));
        }
    }

    @Override
    public Offre addOffre() {
        Offre offre = new Offre();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le titre");
        offre.setTitre(sc.nextLine());
        System.out.println("entrer la description");
        offre.setDescription(sc.nextLine());
        System.out.println("entrer le type de contrat");
        offre.setType(sc.nextLine());
        System.out.println("entrer la ville");
        offre.setVille(sc.nextLine());
        return offre;
    }

    public void afficherOptionInconnue(){System.out.println("offre inconnue");}

    @Override
    public Offre updateOffre() {
        Offre offre = new Offre();
        Scanner sc = new Scanner(System.in);
        System.out.println("saisir l'id de l'offre");
        offre.setId(sc.nextInt());
        System.out.println("entrer le titre");
        offre.setTitre(sc.next());
        System.out.println("entrer la description");
        offre.setDescription(sc.next());
        System.out.println("entrer le type de contrat");
        offre.setType(sc.next());
        System.out.println("entrer la ville");
        offre.setVille(sc.next());
        return offre;
    }

    @Override
    public int deleteOffre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'offre à supprimer");
        return  scanner.nextInt();

    }



    public int sairIdOffre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'offre");
        int a1=scanner.nextInt();
       return a1;
    }
    public int saisirIdCandit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id du candidat");
        int a1=scanner.nextInt();
        return a1;
    }

    @Override
    public String saisirDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir la date ex:2020-12-12");
        String a3=scanner.next();
        return a3;
    }

    @Override
    public String saisirHeure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("saisir l'heure ex :12:14");
        String a4=scanner.next();
        return a4;
    }
}
