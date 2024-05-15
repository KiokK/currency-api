package by.kiok.currency.repository.impl;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.model.Currency;
import by.kiok.currency.model.ExchangeRate;
import by.kiok.currency.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_INTO_EXCHANGE_RATES_RETURN_ID = "insert into exchange_rates(rate, initial_amount, concluding_amount, initial_id, concluding_id) VALUES (?,?,?,?,?) returning id";

    private static final String SELECT_WITH_CURRENCIES =
            "select exchange_rates.*, cInit.money_sign as \"initial.moneySign\", cInit.id as \"initial.id\", " +
                    "cConcl.id as \"concluding.id\", cConcl.money_sign as \"concluding.moneySign\" from exchange_rates " +
            "JOIN currencies cConcl ON cConcl.id = exchange_rates.concluding_id " +
            "JOIN currencies cInit ON cInit.id = exchange_rates.initial_id";

    private static final String SELECT_BY_ID_WITH_CURRENCIES = SELECT_WITH_CURRENCIES + " where exchange_rates.id = ?";

    private static final String SELECT_ALL_LIMIT_OFFSET_WITH_CURRENCIES = SELECT_WITH_CURRENCIES + " limit ? offset ?";

    private static final RowMapper<ExchangeRate> rowMapperWithCurrency = new RowMapper<ExchangeRate>() {
        @Override
        public ExchangeRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExchangeRate found = (new BeanPropertyRowMapper<>(ExchangeRate.class)).mapRow(rs, rowNum);
            if (found != null) {
                Currency initial = new Currency();
                initial.setId(rs.getLong("initial.id"));
                initial.setMoneySign(rs.getString("initial.moneySign"));
                found.setInitial(initial);
                Currency concluding = new Currency();
                concluding.setId(rs.getLong("concluding.id"));
                concluding.setMoneySign(rs.getString("concluding.moneySign"));
                found.setConcluding(concluding);
            }

            return found;
        }
    };

    @Override
    public ExchangeRate create(ExchangeRate exchangeRate) {
        Object[] args = {exchangeRate.getRate(), exchangeRate.getInitialAmount(), exchangeRate.getConcludingAmount(),
                exchangeRate.getInitial().getId(), exchangeRate.getConcluding().getId()};
        int[] argTypes = {Types.NUMERIC, Types.SMALLINT, Types.SMALLINT, Types.BIGINT, Types.BIGINT};
        Long createdId = jdbcTemplate.queryForObject(INSERT_INTO_EXCHANGE_RATES_RETURN_ID,
                args, argTypes, Long.class);

        if (createdId != null) {
            return jdbcTemplate.queryForObject(SELECT_BY_ID_WITH_CURRENCIES, rowMapperWithCurrency, createdId);
        }

        return null;
    }

    @Override
    public Optional<ExchangeRate> findById(long id) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(SELECT_BY_ID_WITH_CURRENCIES, rowMapperWithCurrency, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ExchangeRate> findAll(CustomPageable pageable) {
        try {
            return jdbcTemplate.query(SELECT_ALL_LIMIT_OFFSET_WITH_CURRENCIES, rowMapperWithCurrency,
                    pageable.pageSize(), pageable.getOffset());
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }
}
