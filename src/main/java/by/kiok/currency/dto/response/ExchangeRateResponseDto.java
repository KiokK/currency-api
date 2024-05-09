package by.kiok.currency.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

import static by.kiok.currency.dto.ValidateDtoConstants.DATA_FORMAT;

public record ExchangeRateResponseDto(
        long id,
        long initialCurrencyId,
        String initialMoneySign,
        long concludingCurrencyId,
        String concludingMoneySign,
        int initialAmount,
        int concludingAmount,
        double rate,

        @JsonFormat(pattern = DATA_FORMAT)
        LocalDateTime modifiedAt
) {
}
