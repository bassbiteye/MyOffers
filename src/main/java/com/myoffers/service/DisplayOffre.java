package com.myoffers.service;

import com.myoffers.domain.Offre;

public interface DisplayOffre {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeOffres(Offre[] offres);
    Offre addOffre();
    void  afficherOptionInconnue();
    Offre updateOffre();
    int deleteOffre();

    int sairIdOffre();
    int  saisirIdCandit();
    String saisirDate();
    String saisirHeure();

}
