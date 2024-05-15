package by.kiok.currency.repository;

import by.kiok.currency.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}
