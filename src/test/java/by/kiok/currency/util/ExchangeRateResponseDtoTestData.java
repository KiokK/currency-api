package by.kiok.currency.util;

import by.kiok.currency.dto.response.ExchangeRateResponseDto;

import static by.kiok.currency.util.CurrencyTestData.getCurrencyEur;
import static by.kiok.currency.util.CurrencyTestData.getCurrencyUsd;
import static by.kiok.currency.util.TestConstants.CONCLUDING_AMOUNT;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.DEFAULT_TIME;
import static by.kiok.currency.util.TestConstants.INITIAL_AMOUNT;
import static by.kiok.currency.util.TestConstants.RATE;

public class ExchangeRateResponseDtoTestData {

    public static ExchangeRateResponseDto getExchangeRateResponseDto() {
        return new ExchangeRateResponseDto(
                DEFAULT_ID_1,
                getCurrencyUsd().getId(),
                getCurrencyUsd().getMoneySign(),
                getCurrencyEur().getId(),
                getCurrencyEur().getMoneySign(),
                INITIAL_AMOUNT,
                CONCLUDING_AMOUNT,
                RATE,
                DEFAULT_TIME
        );
    }
}
