package com.myoffers.repository;

import com.myoffers.domain.*;

public interface CandidatRepository {
    Candidat[] getAllCandidat();
    Candidat findById(int idCandidat);
    int postuler(int idOffre,int idCandidat);
    Offre[] mesOffres(int id);
    RV monRv(int idOffre, int idCandidat);
    Recruter recruté(int idOffre, int idCandidat);
    int UpdateProfile(Candidat candidat);

}
