package by.kiok.currency.repository.impl;

import by.kiok.currency.model.User;
import by.kiok.currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_BY_USERNAME = "select * from users where username = ?";

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_USERNAME,
                    new BeanPropertyRowMapper<>(User.class), username));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
