package by.kiok.currency.util;

import by.kiok.currency.model.Currency;
import by.kiok.currency.model.ExchangeRate;

import static by.kiok.currency.util.CurrencyTestData.getCurrencyEur;
import static by.kiok.currency.util.CurrencyTestData.getCurrencyUsd;
import static by.kiok.currency.util.TestConstants.CONCLUDING_AMOUNT;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_2;
import static by.kiok.currency.util.TestConstants.DEFAULT_TIME;
import static by.kiok.currency.util.TestConstants.INITIAL_AMOUNT;
import static by.kiok.currency.util.TestConstants.RATE;

public class ExchangeRateTestData {

    public static ExchangeRate getExchangeRate() {
        ExchangeRate rate = getExchangeRateNullId();
        rate.setId(DEFAULT_ID_1);
        rate.setConcluding(getCurrencyEur());
        rate.setInitial(getCurrencyUsd());
        rate.setCreatedAt(DEFAULT_TIME);
        rate.setModifiedAt(DEFAULT_TIME);
        return rate;
    }

    public static ExchangeRate getExchangeRateNullId() {
        Currency initial = new Currency();
        initial.setId(DEFAULT_ID_1);
        Currency concluding = new Currency();
        initial.setId(DEFAULT_ID_2);
        ExchangeRate rate = new ExchangeRate();
        rate.setConcludingAmount(CONCLUDING_AMOUNT);
        rate.setInitialAmount(INITIAL_AMOUNT);
        rate.setRate(RATE);
        rate.setConcluding(concluding);
        rate.setInitial(initial);
        return rate;
    }
}
