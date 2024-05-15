package by.kiok.currency.util;

import by.kiok.currency.model.Currency;

import java.util.List;

import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_2;
import static by.kiok.currency.util.TestConstants.DEFAULT_MONEY_SIGN_EUR;
import static by.kiok.currency.util.TestConstants.DEFAULT_MONEY_SIGN_USD;
import static by.kiok.currency.util.TestConstants.DEFAULT_TITLE;

public class CurrencyTestData {

    public static Currency getCurrencyUsd() {
        Currency currency = new Currency();
        currency.setTitle(DEFAULT_TITLE);
        currency.setMoneySign(DEFAULT_MONEY_SIGN_USD);
        currency.setId(DEFAULT_ID_1);
        return currency;
    }

    public static Currency getCurrencyEur() {
        Currency currency = new Currency();
        currency.setTitle(DEFAULT_TITLE);
        currency.setMoneySign(DEFAULT_MONEY_SIGN_EUR);
        currency.setId(DEFAULT_ID_2);
        return currency;
    }

    public static List<Currency> getCurrencies() {
        return List.of(getCurrencyUsd(), getCurrencyEur());
    }

    public static Currency getCurrencyIdNull() {
        Currency currency = new Currency();
        currency.setTitle(DEFAULT_TITLE);
        currency.setMoneySign(DEFAULT_MONEY_SIGN_USD);
        return currency;
    }
}
