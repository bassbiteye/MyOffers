package com.myoffers.controller;

import com.myoffers.repository.CandidatRepository;
import com.myoffers.repository.OffreRepository;
import com.myoffers.repository.jdbc.DataSource;
import com.myoffers.repository.jdbc.JdbcCandidatRepository;
import com.myoffers.repository.jdbc.JdbcOffreRepository;
import com.myoffers.repository.jdbc.MysqlDataSource;
import com.myoffers.service.DisplayCandidat;
import com.myoffers.service.DisplayOffre;
import com.myoffers.service.MenuCandidat;
import com.myoffers.service.console.ConsoleDisplayCandidat;
import com.myoffers.service.console.ConsoleDisplayOffre;
import com.myoffers.service.console.ScannerMenuCandidat;

public class CandidatController {
    private final DisplayCandidat displayCandidat ;
    private final MenuCandidat scannerMenuCandidat ;
    private final DisplayOffre displayOffre ;
    public CandidatController(){
        displayOffre = new ConsoleDisplayOffre();
        DataSource dataSource = new MysqlDataSource();
        displayCandidat = new ConsoleDisplayCandidat();
        CandidatRepository candidatRepository = new JdbcCandidatRepository(dataSource);
        OffreRepository offreRepository = new JdbcOffreRepository(dataSource);
        scannerMenuCandidat = new ScannerMenuCandidat(displayOffre, candidatRepository, offreRepository, displayCandidat);
    }

    public void process(){

        displayCandidat.afficherBienvenu();
        displayCandidat.afficherMenuPrincipal();
        scannerMenuCandidat.afficherMenu();
    }

}
