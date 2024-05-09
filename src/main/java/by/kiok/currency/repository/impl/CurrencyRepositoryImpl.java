package by.kiok.currency.repository.impl;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.model.Currency;
import by.kiok.currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrencyRepositoryImpl implements CurrencyRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final String INSERT_INTO_CURRENCIES = "insert into currencies (title, money_sign) values (?, ?) returning *";
    private static final String SELECT_BY_ID = "select * from currencies where id = ?";
    private static final String SELECT_ALL_LIMIT_OFFSET = "select * from currencies order by title desc limit ? offset ?";

    @Override
    public Currency create(Currency currency) {
        Object[] args = {currency.getTitle(), currency.getMoneySign()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR};

        return jdbcTemplate.queryForObject(INSERT_INTO_CURRENCIES, args, argTypes,
                new BeanPropertyRowMapper<>(Currency.class));
    }

    @Override
    public Optional<Currency> findById(long id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Currency.class), id));
    }

    @Override
    public List<Currency> findAllOrderedByTitle(CustomPageable pageable) {
        return jdbcTemplate.query(SELECT_ALL_LIMIT_OFFSET,
                new BeanPropertyRowMapper<>(Currency.class), pageable.pageSize(), pageable.getOffset());
    }
}
