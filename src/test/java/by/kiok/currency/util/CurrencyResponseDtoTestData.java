package by.kiok.currency.util;

import by.kiok.currency.dto.response.CurrencyResponseDto;

import java.util.List;

import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_2;
import static by.kiok.currency.util.TestConstants.DEFAULT_MONEY_SIGN_EUR;
import static by.kiok.currency.util.TestConstants.DEFAULT_MONEY_SIGN_USD;
import static by.kiok.currency.util.TestConstants.DEFAULT_TITLE;

public class CurrencyResponseDtoTestData {

    public static CurrencyResponseDto getCurrencyResponseDtoUsd() {
        return new CurrencyResponseDto(DEFAULT_ID_1, DEFAULT_TITLE, DEFAULT_MONEY_SIGN_USD);
    }

    public static CurrencyResponseDto getCurrencyResponseDtoEur() {
        return new CurrencyResponseDto(DEFAULT_ID_2, DEFAULT_TITLE, DEFAULT_MONEY_SIGN_EUR);
    }

    public static List<CurrencyResponseDto> getCurrencyResponseDtoListSize2() {
        return List.of(getCurrencyResponseDtoUsd(), getCurrencyResponseDtoEur());
    }
}
