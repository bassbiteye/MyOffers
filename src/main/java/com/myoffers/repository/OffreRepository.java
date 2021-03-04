package com.myoffers.repository;

import com.myoffers.domain.Offre;

public interface OffreRepository {
    Offre[] getAllOffres();
    Offre getOffreById(int id);
    int addOffre(Offre offre);
    Offre lastoffre();
    int updateOffre(Offre offre);
    int deleteOffre(int id);
    int selectionner(int idOffre,int idCandidat);
    int donnerRV(String idOffre, String idCandidat, String date, String heure);
    int recruter(int idOffre,int idCandidat);

}
