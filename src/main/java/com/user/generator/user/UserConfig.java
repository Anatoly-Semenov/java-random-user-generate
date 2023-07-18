package com.user.generator.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
         User user1 = new User("Cathy", "Garrett", "04.07.1984", 33, User.Sex.FEMALE, "https://randomuser.me/api/portraits/women/51.jpg");
         User user2 = new User("Amber", "Carlson", "12.12.1990", 33, User.Sex.FEMALE, "https://randomuser.me/api/portraits/women/31.jpg");
         User user3 = new User("Jackie", "Welch", "05.03.1997", 33, User.Sex.MALE, "https://randomuser.me/api/portraits/men/30.jpg");
         User user4 = new User("Donald", "Welch", "12.12.1990", 33, User.Sex.MALE, "https://randomuser.me/api/portraits/men/5.jpg");
        };
    }
}
