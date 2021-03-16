package com.myoffers.repository.jdbc;
import com.myoffers.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class jdbcUserRepositoryTest {
private jdbcUserRepository jdbcUserRepository;
    @BeforeEach
    void setUp() {
        DataSource dataSource = new MockDatasource();
        jdbcUserRepository = new jdbcUserRepository(dataSource);
    }

    @Test
    void addUser() {
        User user = new User(1,"biteye","bassirou","admin");
        int ok = jdbcUserRepository.addUser(user);
        assertEquals(0, ok, "add user success");

    }

    @Test
    void updateUser() {
        User user = new User(1,"biteye","bassirou","admin");
        int ok = jdbcUserRepository.UpdateUser(user);
        assertEquals(0, ok, "update user success");
    }

    @Test
    void deleteUser() {
        int ok = jdbcUserRepository.deleteUser(1);
        assertEquals(0, ok, "delete user success");
    }

    @Test
    void getAllUsers() {
        User[] users = jdbcUserRepository.getAllUsers();
        assertEquals(4, users.length, "le nombre d'utilisations doit être 3");
    }
}
