package com.myoffers.service.console;

import com.myoffers.domain.Candidat;
import com.myoffers.domain.Offre;
import com.myoffers.repository.CandidatRepository;
import com.myoffers.repository.OffreRepository;
import com.myoffers.service.DisplayCandidat;
import com.myoffers.service.DisplayOffre;
import com.myoffers.service.MenuCandidat;

import java.util.Scanner;

public class ScannerMenuCandidat implements MenuCandidat {
    private final DisplayOffre displayOffre;
    private final Scanner scanner;
    private final CandidatRepository candidatRepository;
    private final OffreRepository offreRepository;
    private final DisplayCandidat displayCandidat;
    public ScannerMenuCandidat(DisplayOffre displayOffre, CandidatRepository candidatRepository, OffreRepository offreRepository, DisplayCandidat displayCandidat) {
        this.displayOffre = displayOffre;
        this.offreRepository = offreRepository;
        this.displayCandidat = displayCandidat;
        this.scanner = new Scanner(System.in);
        this.candidatRepository = candidatRepository;
    }




    private int lireChoix() {
        return scanner.nextInt();
    }

    private void afficherMenu( int choix) {
        Candidat[] candidats = candidatRepository.getAllCandidat();
        Offre[] offres = offreRepository.getAllOffres();
        Offre lastoff = offreRepository.lastoffre();

        switch (choix){
                case 1:
                    displayOffre.afficherListeOffres(offres);
                    break;
                case 2:
                    System.out.println("saisir votre id");
                    int id =scanner.nextInt();
                    displayCandidat.profile(candidatRepository.findById(id));

                    break;
                case 3:
                    candidatRepository.UpdateProfile(displayCandidat.updateCandidat()) ;

                    break;
                case 4:
                    candidatRepository.postuler(displayCandidat.postuler()[0],displayCandidat.postuler()[1]) ;
                    break;
                case 5:
                    System.out.println("saisir votre id");
                    int id1 =scanner.nextInt();
                    displayOffre.afficherListeOffres(candidatRepository.mesOffres(id1));
                    break;
                case 6:
                    offreRepository.donnerRV(displayOffre.rv()[0],displayOffre.rv()[1],displayOffre.rv()[2],displayOffre.rv()[3]) ;
                    break;
                case 7:
                    offreRepository.recruter(displayOffre.selectionner()[0],displayOffre.selectionner()[1]);
                    break;
                default:
                    displayOffre.afficherOptionInconnue();
            }

    }

    public void afficherMenu() {
        int choix = lireChoix();
        afficherMenu(choix );
    }
}
