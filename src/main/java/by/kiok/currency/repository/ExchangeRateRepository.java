package by.kiok.currency.repository;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.model.ExchangeRate;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateRepository {

    ExchangeRate create(ExchangeRate exchangeRate);

    Optional<ExchangeRate> findById(long id);

    List<ExchangeRate> findAll(CustomPageable pageable);
}
