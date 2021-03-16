package com.myoffers.service;

import com.myoffers.domain.User;

public interface DisplayUser {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeUsers(User[] users);
    User addUser();
    void  afficherOptionInconnue();
    User updateUser();
    int deleteUser();


}
