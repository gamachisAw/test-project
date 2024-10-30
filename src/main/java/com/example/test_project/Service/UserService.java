package com.example.test_project.Service;

import com.example.test_project.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    void saveUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    void updateUser(User user, long id);

    void deleteUser(long id);
}
