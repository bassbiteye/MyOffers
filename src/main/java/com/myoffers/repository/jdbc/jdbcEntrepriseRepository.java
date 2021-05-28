package com.myoffers.repository.jdbc;

import com.myoffers.domain.Entreprise;
import com.myoffers.repository.EntrepriseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jdbcEntrepriseRepository implements EntrepriseRepository {
    private final DataSource dataSource;

    public jdbcEntrepriseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addEntreprise(Entreprise Entreprise) {
        int ok = 0;
        String query = "INSERT INTO entreprise (raisonSociale,siege,numero) VALUES(?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,Entreprise.getRaisonSociale());
            statement.setString(2, Entreprise.getSiege());
            statement.setString(3, Entreprise.getNumero());
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("Entreprise créé avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int UpdateEntreprise(Entreprise Entreprise) {
        String query = "UPDATE  entreprise SET raisonSociale=?, siege=?, numero=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,Entreprise.getRaisonSociale());
            statement.setString(2, Entreprise.getSiege());
            statement.setString(3, Entreprise.getNumero());
            statement.setInt(4, Entreprise.getId());

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("Entreprise est modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEntreprise(int id) {
        String query = "DELETE FROM entreprise where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("Entreprise est supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Entreprise>  getAllEntreprises() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM entreprise";
        //mapper le résultat
        List<Entreprise> entreprises = new ArrayList<Entreprise>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String raisonSociale = rs.getString("raisonSociale");
                String siege = rs.getString("siege");
                String numero = rs.getString("numero");
                String login = rs.getString("login");

                //mapping retour db (relationnel) avec objet Offre
                Entreprise entreprise = new Entreprise(id, raisonSociale,siege,numero);

                entreprises.add(entreprise);
            }
            return entreprises;

        }
        catch (SQLException e) {
            return Arrays.asList(new Entreprise[0]);
        }
        catch (Exception ex){
            return Arrays.asList(new Entreprise[0]);
        }
    }


}
