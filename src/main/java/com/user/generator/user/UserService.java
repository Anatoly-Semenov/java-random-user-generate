package com.user.generator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserDetail(Long id) {
        boolean isExist = this.userRepository.existsById(id);

        if(!isExist) {
            throw new IllegalStateException("User with id: " + id + ", is not exist");
        }

        return this.userRepository.findById(id);
    }

    public User createUser(User newUser) {
        return this.userRepository.save(newUser);
    }

    public String deleteUserById(Long id) {
        boolean isExist = this.userRepository.existsById(id);

        if (!isExist) {
            throw new IllegalStateException("User with id: " + id + " is not exist");
        }

        this.userRepository.deleteById(id);
        return "User with id: " + id + " successful deleted";
    }

    public Optional<User> generateRandomUser() {
        Random random = new Random();

        int usersCount = (int)this.userRepository.count();
        long userId = random.nextInt(usersCount);

        return this.getUserDetail(userId);
    }
}
