package by.kiok.currency.dto.response;

import java.util.List;

public record PageExchangeRateResponseDto(
        List<ExchangeRateResponseDto> exchangeRates,
        int pageNumber,
        int pageSize
) {
}
