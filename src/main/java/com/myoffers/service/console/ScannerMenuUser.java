package com.myoffers.service.console;

import com.myoffers.domain.User;
import com.myoffers.repository.UserRepository;
import com.myoffers.service.DisplayUser;
import com.myoffers.service.MenuUser;

import java.util.Scanner;

public class ScannerMenuUser implements MenuUser {
    private final DisplayUser displayUser;
    private final Scanner scanner;
    private UserRepository userRepository;

    public ScannerMenuUser(DisplayUser displayUser, UserRepository userRepository) {
        this.displayUser = displayUser;
        this.scanner = new Scanner(System.in);
        this.userRepository = userRepository;
    }

    private int lireChoix() {
        return scanner.nextInt();
    }

    private void afficherMenu( int choix) {

        User[] users = userRepository.getAllUsers();
        switch (choix){
                case 1:
                    displayUser.afficherListeUsers(users);
                    break;
                case 2:
                    userRepository.addUser(displayUser.addUser()) ;
                    displayUser.afficherListeUsers(users);
                break;
                case 3:
                    userRepository.UpdateUser(displayUser.updateUser()) ;
                    displayUser.afficherListeUsers(users);
                    break;
                case 4:
                    userRepository.deleteUser(displayUser.deleteUser()) ;
                    displayUser.afficherListeUsers(users);
                    break;

                default:
                    displayUser.afficherOptionInconnue();
            }

    }

    public void afficherMenu() {
        int choix = lireChoix();
        afficherMenu(choix );
    }
}
