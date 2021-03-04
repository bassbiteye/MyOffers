package com.myoffers.repository;

import com.myoffers.domain.Candidat;
import com.myoffers.domain.Offre;
import com.myoffers.domain.OffreUser;

public interface CandidatRepository {
    Candidat[] getAllCandidat();
    Candidat findById(int idCandidat);
    int postuler(int idOffre,int idCandidat);
    Offre[] mesOffres(int id);
    OffreUser monRv(int idOffre,int idCandidat);
    OffreUser recruté(int idOffre, int idCandidat);
    int UpdateProfile(Candidat candidat);

}
