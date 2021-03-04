package com.myoffers;

import com.myoffers.controller.CandidatController;
import com.myoffers.controller.EntrepriseController;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Bienvenu sur la plateforme des offres!" );
        System.out.println( "tapez votre choix sur le menu suviant!" );
        System.out.println( "1 panel admin" );
        System.out.println( "2 entreprise" );
        System.out.println( "3 candidat " );

        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
            case 1:
                System.out.println( "menu admin" );
                break;
            case 2:
                System.out.println( "menu Entreprise" );
                EntrepriseController entrepriseController = new EntrepriseController();
                entrepriseController.process();
                break;
            case 3:
                System.out.println( "menu candidat" );
                CandidatController candidatController = new CandidatController();
                candidatController.process();
                break;
            default:
                System.out.println( "menu introuvable" );

        }


    }
}