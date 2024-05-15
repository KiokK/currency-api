package by.kiok.currency.util;

import by.kiok.currency.dto.request.ExchangeRateRequestDto;

import static by.kiok.currency.util.CurrencyTestData.getCurrencyEur;
import static by.kiok.currency.util.CurrencyTestData.getCurrencyUsd;
import static by.kiok.currency.util.TestConstants.CONCLUDING_AMOUNT;
import static by.kiok.currency.util.TestConstants.INITIAL_AMOUNT;
import static by.kiok.currency.util.TestConstants.RATE;

public class ExchangeRateRequestDtoTestData {

    public static ExchangeRateRequestDto getExchangeRateRequestDto() {
        return new ExchangeRateRequestDto(
                getCurrencyUsd().getId(),
                getCurrencyEur().getId(),
                INITIAL_AMOUNT,
                CONCLUDING_AMOUNT,
                RATE
        );
    }
}
