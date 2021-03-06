package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.User;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public MessageResponse addUser(User user) {
        userRepository.save(user);
        return new MessageResponse(MessageType.SUCCESS, "User is added");
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(() -> new EntityNotFoundException("User is not found by given username"));
    }
}
