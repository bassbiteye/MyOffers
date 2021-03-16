package com.myoffers.service.console;


import com.myoffers.domain.User;
import com.myoffers.service.DisplayUser;

import java.util.Scanner;

public class ConsoleDisplayUser implements DisplayUser {


    public ConsoleDisplayUser() {
    }

    public void afficherBienvenu() {
        System.out.println("Bienvenu sur la panel !");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 lister des utilisateurs");
        System.out.println("2 ajouter un user");
        System.out.println("3 modifier un user");
        System.out.println("4 supprimer un user");

    }




    @Override
    public void afficherListeUsers(User[] users) {
        System.out.println("Les offres disponibles sont:");
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            System.out.println(String.format("> %s %s %s %s ", user.getId(), user.getNom(),user.getPrenom(),user.getRole()));
        }
    }

    @Override
    public User addUser() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom");
        user.setNom(sc.nextLine());
        System.out.println("entrer la prenom");
        user.setPrenom(sc.nextLine());
        System.out.println("entrer le role");
        user.setRole(sc.nextLine());
        return user;
    }

    public void afficherOptionInconnue(){System.out.println("offre inconnue");}

    @Override
    public User updateUser() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("saisir l'id de l'user");
        user.setId(sc.nextInt());
        System.out.println("entrer le nom");
        user.setNom(sc.nextLine());
        System.out.println("entrer la prenom");
        user.setPrenom(sc.nextLine());
        System.out.println("entrer le role");
        user.setRole(sc.nextLine());
        return user;
    }

    @Override
    public int deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'user à supprimer");
        return  scanner.nextInt();
    }

}
