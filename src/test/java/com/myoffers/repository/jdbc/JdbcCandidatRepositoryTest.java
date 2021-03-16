package com.myoffers.repository.jdbc;

import com.myoffers.domain.Candidat;
import com.myoffers.domain.Offre;
import com.myoffers.domain.RV;
import com.myoffers.domain.Recruter;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JdbcCandidatRepositoryTest {
    @Mock
    private JdbcCandidatRepository jdbcCandidatRepository;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        DataSource dataSource = new MockDatasource();
        jdbcCandidatRepository = new JdbcCandidatRepository(dataSource);
    }
    @Test
    void getAllCandidat() {
        System.out.println("Dans la méthode get candidats");
        Candidat[] candidats = jdbcCandidatRepository.getAllCandidat();
        assertEquals(4, candidats.length, "le nombre de candidats doit être 4");
    }

    @Test
    void findById(){
        System.out.println("Dans la méthode find by id");
        Candidat candidat = jdbcCandidatRepository.findById(2);
        assertNotNull(candidat);
        assertEquals(1, candidat.getId());
        assertEquals("", candidat.getNom());
    }

    @Test
    void postuler() {
        System.out.println("Dans la méthode postuler");
        int ok = jdbcCandidatRepository.postuler(1,1);
        assertEquals(0, ok);

    }

    @Test
    void mesOffres() {
        System.out.println("Dans la méthode mesOffres");
        Offre[] offres = jdbcCandidatRepository.mesOffres(2);
        assertEquals(0, offres.length, "le nombre d'offres doit être 2");
    }

    @Test
    void monRv() {
        System.out.println("Dans la méthode monRV");
        RV rv = jdbcCandidatRepository.monRv(1,1);
        assertEquals(0, rv);
    }

    @Test
    void recruté() {
        System.out.println("Dans la méthode recruté");
        Recruter recruter = jdbcCandidatRepository.recruté(1,1);
        assertEquals(0, recruter);
    }

    @Test
    void updateProfile() {
        Candidat candidat = new Candidat(1,"fall","kader");
        int ok = jdbcCandidatRepository.UpdateProfile(candidat);
        assertEquals(0,ok);
    }
}
