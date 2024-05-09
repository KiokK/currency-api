package by.kiok.currency.dto.response;

import java.util.List;

public record PageCurrencyResponseDto(
        List<CurrencyResponseDto> currencies,
        int pageNumber,
        int pageSize
) {
}
