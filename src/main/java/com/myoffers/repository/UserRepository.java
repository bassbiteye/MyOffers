package com.myoffers.repository;

import com.myoffers.domain.User;

public interface UserRepository {
    int addUser(User user);
    int UpdateUser(User user);
    int deleteUser(int id);
    User[] getAllUsers();

     User logon(String login, String password);

}
