package com.myoffers.repository;

import com.myoffers.domain.Entreprise;

import java.util.List;

public interface EntrepriseRepository {
    int addEntreprise(Entreprise entreprise);
    int UpdateEntreprise(Entreprise entreprise);
    int deleteEntreprise(int id);
    List<Entreprise> getAllEntreprises();


}
