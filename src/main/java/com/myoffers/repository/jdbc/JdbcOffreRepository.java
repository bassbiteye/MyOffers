package com.myoffers.repository.jdbc;

import com.myoffers.domain.Offre;
import com.myoffers.repository.OffreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcOffreRepository implements OffreRepository {
    private final DataSource dataSource;

    public JdbcOffreRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Offre[] getAllOffres() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM offres";
        //mapper le résultat
        List<Offre> offres = new ArrayList<Offre>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                String type = rs.getString("type");
                String ville = rs.getString("ville");

                //mapping retour db (relationnel) avec objet Offre
                Offre offre = new Offre( id, titre,description,date,type,ville);

                offres.add(offre);
            }
            return offres.toArray(new Offre[0]);

        }
        catch (SQLException e) {
            return new Offre[0];
        }
        catch (Exception ex){
            return new Offre[0];
        }
    }

    @Override
    public Offre getOffreById(int id) {
        String query = "SELECT * FROM offres where id:?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idOffre = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                String type = rs.getString("type");
                String ville = rs.getString("ville");

                Offre offre = new Offre(idOffre, titre, description, date, type, ville);

            return offre;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int addOffre(Offre offre) {
        int ok = 0;
        String query = "INSERT INTO offres (titre,description,type,ville) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,offre.getTitre());
            statement.setString(2, offre.getDescription());
            statement.setString(3, offre.getVille());
            statement.setString(4, offre.getType());
            System.out.println(statement);
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("offre créé avec succés!");
            }
         return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Offre lastoffre() {
        String lastRow = "SELECT * FROM offres ORDER BY ID DESC LIMIT 1";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(lastRow);
            if (rs.next()) {
                int idOffre = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                String type = rs.getString("type");
                String ville = rs.getString("ville");
                return new Offre(idOffre, titre, description, date, type, ville);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  null;
    }

    @Override
    public int updateOffre(Offre offre) {
        String query = "UPDATE  offres SET titre=?, description=?, type=?, ville=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println(statement);
            statement.setString(1,offre.getTitre());
            statement.setString(2, offre.getDescription());
            statement.setString(3, offre.getVille());
            statement.setString(4, offre.getType());
            statement.setInt(5, offre.getId());

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("offre est modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOffre(int id) {
        String query = "DELETE FROM offres where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("offre est supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int selectionner(int idOffre, int idCandidat) {
        int ok =0;
        String sql1 = "SELECT * FROM offre_user where id_offre=? and id_candidat=?";
        String query = "SELECT * FROM selectionner where id_offre=? and id_candidat=?";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement stment = connection.prepareStatement(sql1);
            stment.setInt(1, idOffre);
            stment.setInt(2, idCandidat);
            ResultSet result = stment.executeQuery();
            if (result.next()) {
                try {
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, idOffre);
                    statement.setInt(2,idCandidat);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        System.out.println("candidat déja selectionné ");

                    }else {
                        String sql = "INSERT INTO selectionner (id_offre,id_candidat) VALUES(?,?)";
                        PreparedStatement stm = connection.prepareStatement(sql);
                        System.out.println(idOffre);
                        stm.setInt(1,idOffre);
                        stm.setInt(2, idCandidat);
                        ok = stm.executeUpdate();
                        if (ok > 0) {
                            System.out.println("candidat selectionné!");
                            return ok;
                        }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }else {
                System.out.println("Le candidat n'a pas encore postulé sur cette offre");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }



        return ok;

    }

    @Override
    public int donnerRV(int idOffre, int idCandidat, String date, String heure) {
        int ok =0;
        String sql1 = "SELECT * FROM selectionner where id_offre=? and id_candidat=?";
        String query = "SELECT * FROM rv where id_offre=? and id_candidat=?";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement stment = connection.prepareStatement(sql1);
            stment.setInt(1, idOffre);
            stment.setInt(2, idOffre);
            ResultSet result = stment.executeQuery();
            if (result.next()) {
                try {
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, idOffre);
                    statement.setInt(2,idCandidat);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        System.out.println("candidat a déja un rv ");

                    }else {
                        String sql = "INSERT INTO rv (id_offre,id_candidat,date,heure) VALUES(?,?,?,?)";
                        PreparedStatement stm = connection.prepareStatement(sql);
                        System.out.println(idOffre);
                        stm.setInt(1,idOffre);
                        stm.setInt(2, idCandidat);
                        stm.setString(3, date);
                        stm.setString(4, heure);

                        ok = stm.executeUpdate();
                        if (ok > 0) {
                            System.out.println("rv accordé!");
                            return ok;
                        }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }else {
                System.out.println("Le candidat n'a pas été selectionné");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return 0;
    }



    @Override
    public int recruter(int idOffre, int idCandidat) {
        int ok =0;
        String sql1 = "SELECT * FROM rv where id_offre=? and id_candidat=?";
        String query = "SELECT * FROM recruter where id_offre=? and id_candidat=?";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement stment = connection.prepareStatement(sql1);
            stment.setInt(1, idOffre);
            stment.setInt(2, idCandidat);
            ResultSet result = stment.executeQuery();
            if (result.next()) {
                try {
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, idOffre);
                    statement.setInt(2,idCandidat);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        System.out.println("candidat déja recruté ");

                    }else {
                        String sql = "INSERT INTO recruter (id_offre,id_candidat) VALUES(?,?)";
                        PreparedStatement stm = connection.prepareStatement(sql);
                        System.out.println(idOffre);
                        stm.setInt(1,idOffre);
                        stm.setInt(2, idCandidat);
                        ok = stm.executeUpdate();
                        if (ok > 0) {
                            System.out.println("candidat recruté!");
                            return ok;
                        }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }else {
                System.out.println("Le candidat n'a pas encore de rv");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }



        return ok;
    }
}
