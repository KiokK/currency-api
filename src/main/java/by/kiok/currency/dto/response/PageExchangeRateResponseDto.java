package by.kiok.currency.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Page of exchange rates response example")
public record PageExchangeRateResponseDto(

        @ApiModelProperty(value = "List of exchange rates", required = true)
        List<ExchangeRateResponseDto> exchangeRates,

        @ApiModelProperty(value = "Page number - positive value", example = "1", required = true)
        int pageNumber,

        @ApiModelProperty(value = "Page size - positive value", example = "1", required = true)
        int pageSize
) {
}
