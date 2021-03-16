package com.myoffers.repository.jdbc;

import com.myoffers.domain.*;
import com.myoffers.repository.CandidatRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcCandidatRepository implements CandidatRepository {
    private final DataSource dataSource;

    public JdbcCandidatRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Candidat[] getAllCandidat() {
        //requête sql pour récupèrer les infos
        String query = "SELECT id, nom,prenom FROM candidat";
        //mapper le résultat
        List<Candidat> candidats = new ArrayList<Candidat>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                //mapping retour db (relationnel) avec objet Candidat
                Candidat candidat = new Candidat( id, nom,prenom);

                candidats.add(candidat);
            }
            return candidats.toArray(new Candidat[0]);

        }
        catch (SQLException e) {
            return new Candidat[0];
        }
        catch (Exception ex){
            return new Candidat[0];
        }

    }

    @Override
    public Candidat findById(int id) {
        String query = "SELECT id, nom,prenom from candidat where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int retrievedId = rs.getInt("id");
                String retrievedName = rs.getString("nom");
                String retrievedPrenom = rs.getString("prenom");

                Candidat candidat = new Candidat(retrievedId, retrievedName, retrievedPrenom);
                return candidat;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int postuler(int idOffre, int idCandidat) {
        int ok =0;
        String sql1 = "SELECT * FROM offre_user where id_offre=? and id_candidat=?";
        String query = "SELECT * FROM selectionner where id_offre=? and id_candidat=?";

                try {
                    Connection connection = dataSource.createConnection();

                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, idOffre);
                    statement.setInt(2,idCandidat);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        System.out.println("tu a déja postulé");

                    }else {
                        String sql = "INSERT INTO offre_user (id_offre,id_candidat) VALUES(?,?)";
                        PreparedStatement stm = connection.prepareStatement(sql);
                        System.out.println(idOffre);
                        stm.setInt(1,idOffre);
                        stm.setInt(2, idCandidat);
                        ok = stm.executeUpdate();
                        if (ok > 0) {
                            System.out.println("tu as postulé !");
                            return ok;
                        }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
        return ok;
    }

    @Override
    public Offre[] mesOffres(int idCandidat) {

        String query = "SELECT o.id,o.titre,o.description,o.date,o.type,o.ville FROM offre_user ou,offres o where id_candidat=? and ou.id_offre = o.id";
        List<Offre> offres = new ArrayList<Offre>();

        try {
            Connection connection = dataSource.createConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,idCandidat);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("o.id");
                String titre = rs.getString("o.titre");
                String description = rs.getString("o.description");
                Date date = rs.getDate("o.date");
                String type = rs.getString("o.type");
                String ville = rs.getString("o.ville");

                //mapping retour db (relationnel) avec objet Offre
                System.out.println(titre);
                Offre offre = new Offre( id, titre,description,date,type,ville);

                offres.add(offre);
            }
            return offres.toArray(new Offre[0]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new Offre[0];
    }

    @Override
    public RV monRv(int idOffre, int idCandidat) {

        String query = "SELECT * FROM rv,offres o where id_offre=? and id_candidat=? and o.id =id_offre";

        try {
            Connection connection = dataSource.createConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idOffre);
            statement.setInt(2,idCandidat);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("o.id");
                String titre = rs.getString("o.titre");
                String description = rs.getString("o.description");
                Date date = rs.getDate("o.date");
                String type = rs.getString("o.type");
                String ville = rs.getString("o.ville");
                String dateRv = rs.getString( "date");
                String timeRv = rs.getString("heure");
                System.out.println(titre);
                Offre offre = new Offre( id, titre,description,date,type,ville);
                RV rv = new RV(offre,dateRv,timeRv);

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Recruter recruté(int idOffre, int idCandidat) {
        String query = "SELECT * FROM recruter,offres o where id_offre=? and id_candidat=? and o.id =id_offre";

        try {
            Connection connection = dataSource.createConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idOffre);
            statement.setInt(2,idCandidat);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("o.id");
                String titre = rs.getString("o.titre");
                String description = rs.getString("o.description");
                Date date = rs.getDate("o.date");
                String type = rs.getString("o.type");
                String ville = rs.getString("o.ville");

                System.out.println(titre);
                Offre offre = new Offre( id, titre,description,date,type,ville);
                Recruter recruter = new Recruter(offre);

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int UpdateProfile(Candidat candidat) {
        String query = "UPDATE  candidat SET nom=?, prenom=? where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println(statement);
            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getNom());
            statement.setInt(3, candidat.getId());

            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("profile modifiée avec succés!");
            }
        } catch (Exception ex){
                ex.printStackTrace();
            }
            return 0;
    }
}
