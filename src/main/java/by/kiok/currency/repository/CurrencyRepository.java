package by.kiok.currency.repository;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.model.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {

    Currency create(Currency currency);

    Optional<Currency> findById(long id);

    List<Currency> findAllOrderedByTitle(CustomPageable pageable);
}
