package com.myoffers.controller;

import com.myoffers.repository.CandidatRepository;
import com.myoffers.repository.OffreRepository;
import com.myoffers.repository.jdbc.DataSource;
import com.myoffers.repository.jdbc.JdbcCandidatRepository;
import com.myoffers.repository.jdbc.JdbcOffreRepository;
import com.myoffers.repository.jdbc.MysqlDataSource;
import com.myoffers.service.DisplayOffre;
import com.myoffers.service.MenuOffre;
import com.myoffers.service.console.ConsoleDisplayOffre;
import com.myoffers.service.console.ScannerMenuOffre;


/**
 * End point destiné aux clients
 * Deux fonctionnalités (offres)
 * 1 - Afficher le menu au client : ConsoleDisplayOffre
 * 2 - Lire les choix du client et afficher le sous-menu correspondant : ScannerMenuOffre
 */
public class EntrepriseController {
    private final DisplayOffre displayOffre ;
    private final MenuOffre scannerMenuOffre ;

    public EntrepriseController(){
        DataSource dataSource = new MysqlDataSource();
        displayOffre = new ConsoleDisplayOffre();
        CandidatRepository candidatRepository = new JdbcCandidatRepository(dataSource);
       OffreRepository offreRepository = new JdbcOffreRepository(dataSource);
        scannerMenuOffre = new ScannerMenuOffre(displayOffre, candidatRepository, offreRepository);
    }

    public void process(){

        displayOffre.afficherBienvenu();
        displayOffre.afficherMenuPrincipal();
        scannerMenuOffre.afficherMenu();
    }


}
