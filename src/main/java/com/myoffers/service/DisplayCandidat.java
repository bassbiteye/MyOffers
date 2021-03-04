package com.myoffers.service;

import com.myoffers.domain.Candidat;

public interface DisplayCandidat {

    void afficherBienvenu();
    void afficherMenuPrincipal();
    void profile(Candidat candidat);
    int[] postuler();
    Candidat updateCandidat();

   /* void  afficherOptionInconnue();
    Offre updateOffre();
    int deleteOffre();
    String[] rv();
    int[] selectionner();*/
}
