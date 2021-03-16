package com.myoffers.repository.jdbc;

import com.myoffers.domain.User;
import com.myoffers.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcUserRepository implements UserRepository {
    private final DataSource dataSource;

    public jdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addUser(User user) {
        int ok = 0;
        String query = "INSERT INTO user (nom,prenom,role) VALUES(?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getRole());
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("user créé avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int UpdateUser(User user) {
        String query = "UPDATE  user SET nom=?, prenom=?, role=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getRole());
            statement.setInt(4, user.getId());

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("user est modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        String query = "DELETE FROM user where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("user est supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public User[] getAllUsers() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM user";
        //mapper le résultat
        List<User> users = new ArrayList<User>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String role = rs.getString("role");

                //mapping retour db (relationnel) avec objet Offre
                User user = new User( id, nom,prenom,role);

                users.add(user);
            }
            return users.toArray(new User[0]);

        }
        catch (SQLException e) {
            return new User[0];
        }
        catch (Exception ex){
            return new User[0];
        }
    }
}
