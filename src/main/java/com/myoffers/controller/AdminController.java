package com.myoffers.controller;

import com.myoffers.repository.UserRepository;
import com.myoffers.repository.jdbc.DataSource;
import com.myoffers.repository.jdbc.MysqlDataSource;
import com.myoffers.repository.jdbc.jdbcUserRepository;
import com.myoffers.service.DisplayUser;
import com.myoffers.service.MenuUser;
import com.myoffers.service.console.ConsoleDisplayUser;
import com.myoffers.service.console.ScannerMenuUser;

public class AdminController {
    private final DisplayUser displayUser ;
    private final MenuUser scannerMenuUser;


    public AdminController() {
        displayUser = new ConsoleDisplayUser();
        DataSource dataSource = new MysqlDataSource();
        UserRepository userRepository = new jdbcUserRepository(dataSource);
        scannerMenuUser = new ScannerMenuUser(displayUser,userRepository);
    }

    public void process(){

        displayUser.afficherBienvenu();
        displayUser.afficherMenuPrincipal();
        scannerMenuUser.afficherMenu();
    }
}
