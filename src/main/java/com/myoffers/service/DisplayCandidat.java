package com.myoffers.service;

import com.myoffers.domain.Candidat;
import com.myoffers.domain.RV;
import com.myoffers.domain.Recruter;

public interface DisplayCandidat {

    void afficherBienvenu();
    void afficherMenuPrincipal();
    void profile(Candidat candidat);
    int[] postuler();
    Candidat updateCandidat();
    void RV(RV rv);
    void Recruter(Recruter recruter);

}
