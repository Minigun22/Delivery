package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.user.User;
import com.cooldelivery.delivery.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
