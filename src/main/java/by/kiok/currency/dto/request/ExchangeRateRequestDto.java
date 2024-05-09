package by.kiok.currency.dto.request;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import static by.kiok.currency.dto.ValidateDtoConstants.EXCHANGE_RATE_RATE_MAX_DECIMAL;
import static by.kiok.currency.dto.ValidateDtoConstants.EXCHANGE_RATE_RATE_MIN_DECIMAL;

public record ExchangeRateRequestDto (

        @Min(1)
        long initialCurrencyId,

        @Min(1)
        long concludingCurrencyId,

        @Min(1)
        int initialAmount,

        @Min(1)
        int concludingAmount,

        @DecimalMin(EXCHANGE_RATE_RATE_MIN_DECIMAL)
        @DecimalMax(EXCHANGE_RATE_RATE_MAX_DECIMAL)
        double rate
) {
}
