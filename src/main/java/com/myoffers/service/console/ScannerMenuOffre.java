package com.myoffers.service.console;

import com.myoffers.domain.Candidat;
import com.myoffers.domain.Offre;
import com.myoffers.repository.CandidatRepository;
import com.myoffers.repository.OffreRepository;
import com.myoffers.service.DisplayOffre;
import com.myoffers.service.MenuOffre;

import java.util.Scanner;

public class ScannerMenuOffre implements MenuOffre {
    private final DisplayOffre displayOffre;
    private final Scanner scanner;
    private final CandidatRepository candidatRepository;
    private final OffreRepository offreRepository;
    public ScannerMenuOffre(DisplayOffre displayOffre, CandidatRepository candidatRepository, OffreRepository offreRepository) {
        this.displayOffre = displayOffre;
        this.offreRepository = offreRepository;
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
                    offreRepository.addOffre(displayOffre.addOffre()) ;
                    displayOffre.afficherListeOffres(offres);
                break;
                case 3:
                    offreRepository.updateOffre(displayOffre.updateOffre()) ;
                    displayOffre.afficherListeOffres(offres);
                    break;
                case 4:
                    offreRepository.deleteOffre(displayOffre.deleteOffre()) ;
                    displayOffre.afficherListeOffres(offres);
                    break;
                case 5:
                    offreRepository.selectionner(displayOffre.sairIdOffre(),displayOffre.saisirIdCandit()) ;
                    break;
                case 6:
                    offreRepository.donnerRV(displayOffre.sairIdOffre(),displayOffre.saisirIdCandit(),displayOffre.saisirDate(),displayOffre.saisirHeure()) ;
                    break;
                case 7:
                    offreRepository.recruter(displayOffre.sairIdOffre(),displayOffre.saisirIdCandit());
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
