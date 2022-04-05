package com.example.testconstructor.Users;

import com.example.testconstructor.Test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){ this.userRepository=userRepository;}

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, String user_name, String user_surname) {
        User user = new User();
        user.setUser_id(id);
        user.setUser_name(user_name);
        user.setUser_surname(user_surname);
        return userRepository.save(user);
    }
}
