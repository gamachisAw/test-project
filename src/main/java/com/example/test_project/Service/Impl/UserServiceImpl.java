package com.example.test_project.Service.Impl;

import com.example.test_project.Model.User;
import com.example.test_project.Repository.UserRepository;
import com.example.test_project.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private  final  UserRepository userRepository;

    @Override
    public  void saveUser(User user){
    userRepository.save(user);
        }
    @Override
     public List<User> getAllUsers(){
        return userRepository.findAll();
     }
    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user, long id) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(user1);
    }
    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

}
