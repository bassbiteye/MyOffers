package com.myoffers.controller.servlet;

import com.myoffers.domain.Entreprise;
import com.myoffers.domain.User;
import com.myoffers.repository.jdbc.DataSource;
import com.myoffers.repository.jdbc.MysqlDataSource;
import com.myoffers.repository.jdbc.jdbcEntrepriseRepository;
import com.myoffers.repository.jdbc.jdbcUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EntrepriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = new MysqlDataSource();

        jdbcEntrepriseRepository jdbcEntrepriseRepository = new jdbcEntrepriseRepository(dataSource);
        List<Entreprise> entreprises = jdbcEntrepriseRepository.getAllEntreprises();
        req.setAttribute("entreprises",entreprises);

        getServletContext().getRequestDispatcher("/WEB-INF/entreprise.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login");
        String pwd = req.getParameter("password");
        DataSource dataSource = new MysqlDataSource();

        jdbcUserRepository jdbcUserRepository = new jdbcUserRepository(dataSource);
        User u =  jdbcUserRepository.logon("admin@admin.com","password");
        if(u!= null){
            HttpSession session = req.getSession(true);
            session.setAttribute("connectedUser",u);
            if(u.getRole().equalsIgnoreCase("user")){
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
            }else{
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("error","login ou password incorrecte");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }
    }

}
