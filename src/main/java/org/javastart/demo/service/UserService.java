package org.javastart.demo.service;

import org.javastart.demo.model.User;
import org.javastart.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
