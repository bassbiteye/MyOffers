package com.myoffers.repository.jdbc;

import com.myoffers.domain.Offre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JdbcOffreRepositoryTest {
private JdbcOffreRepository jdbcOffreRepository;
    @BeforeEach
    void setUp() {
        System.out.println("Dans la méthode setup");
        DataSource dataSource = new MockDatasource();
        jdbcOffreRepository = new JdbcOffreRepository(dataSource);
    }

    @Test
    void getAllOffres() {
        Offre[] offres = jdbcOffreRepository.getAllOffres();
        assertEquals(4, offres.length, "le nombre d'offre doit être 3");

    }

    @Test
    void getOffreById() {
        Offre offre =jdbcOffreRepository.getOffreById(1);
        assertNotNull(offre);
        assertEquals(1, offre.getId());
        assertEquals("", offre.getTitre());
    }

    @Test
    void addOffre() {
        Offre offre = new Offre(1,"titre 1","desc","stage","kaolack");
        int ok = jdbcOffreRepository.addOffre(offre);
        assertEquals(0, ok, "add offre success");
    }



    @Test
    void updateOffre() {
        Offre offre = new Offre(1,"titre 1","desc","stage","kaolack");
        int ok = jdbcOffreRepository.updateOffre(offre);
        assertEquals(0, ok, "update offre success");
    }

    @Test
    void deleteOffre() {
        int ok = jdbcOffreRepository.deleteOffre(1);
        assertEquals(0, ok, "delete offre success");
    }

    @Test
    void selectionner() {
        int ok = jdbcOffreRepository.selectionner(1,1);
        assertEquals(0, ok, "candidat selectionné success");

    }
    @Test
    void rv(){
        int ok = jdbcOffreRepository.donnerRV(1,1,"2021-02-02","10:10");
        assertEquals(0, ok, " rv pris avec  success");

    }
}
