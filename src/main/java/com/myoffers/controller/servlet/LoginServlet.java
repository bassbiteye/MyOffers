package com.myoffers.controller.servlet;

import com.myoffers.domain.User;
import com.myoffers.repository.jdbc.DataSource;
import com.myoffers.repository.jdbc.MysqlDataSource;
import com.myoffers.repository.jdbc.jdbcUserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Bonjour la classe");
        // Charge une page de redirection
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("login");
        String pwd = req.getParameter("password");
        DataSource dataSource = new MysqlDataSource();

        jdbcUserRepository jdbcUserRepository = new jdbcUserRepository(dataSource);
        User u =  jdbcUserRepository.logon(log,pwd);
        if(u!= null){
            HttpSession session = req.getSession();
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
