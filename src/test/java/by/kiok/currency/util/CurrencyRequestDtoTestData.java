package by.kiok.currency.util;

import by.kiok.currency.dto.request.CurrencyRequestDto;

import static by.kiok.currency.util.TestConstants.DEFAULT_MONEY_SIGN_USD;
import static by.kiok.currency.util.TestConstants.DEFAULT_TITLE;

public class CurrencyRequestDtoTestData {

    public static CurrencyRequestDto getCurrencyRequestDto() {
        return new CurrencyRequestDto(DEFAULT_TITLE, DEFAULT_MONEY_SIGN_USD);
    }
}
