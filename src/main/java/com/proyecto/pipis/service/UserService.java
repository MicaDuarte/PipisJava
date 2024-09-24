package com.proyecto.pipis.service;

import com.proyecto.pipis.entity.User;
import com.proyecto.pipis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        user.setRole(user.getRole() != null ? user.getRole() : "USER"); // Asignar rol si está vacío
        userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}