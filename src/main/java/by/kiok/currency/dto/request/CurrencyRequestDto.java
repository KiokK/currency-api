package by.kiok.currency.dto.request;

import javax.validation.constraints.Size;

import static by.kiok.currency.dto.ValidateDtoConstants.CURRENCY_MONEY_SIGN_SIZE;
import static by.kiok.currency.dto.ValidateDtoConstants.CURRENCY_TITLE_SIZE;

public record CurrencyRequestDto(

        @Size(min = 1, max = CURRENCY_TITLE_SIZE)
        String title,

        @Size(min = 1, max = CURRENCY_MONEY_SIGN_SIZE)
        String moneySign
) {
}
