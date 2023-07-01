package com.user.generator.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    private final User user1 = new User(
            1L,
            "John",
            "Cena",
            LocalDate.of(1990, Month.JANUARY, 1),
            21
    );
    private final User user2 = new User(
            2L,
            "John",
            "Cena",
            LocalDate.of(1990, Month.JANUARY, 1),
            21
    );
    private final User user3 = new User(
            3L,
            "John",
            "Cena",
            LocalDate.of(1990, Month.JANUARY, 1),
            21
    );

    private final List<User> users = List.of(user1, user2, user3);

    public List<User> getUsers() {

        return this.users;
    }

    public User getUser(Long id) {
        return this.users.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny()
                .orElse(null);
    }
}
