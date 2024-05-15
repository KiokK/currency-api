package by.kiok.currency.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Page response of currency example")
public record PageCurrencyResponseDto(

        @ApiModelProperty(value = "List of currency", required = true)
        List<CurrencyResponseDto> currencies,

        @ApiModelProperty(value = "Page number - positive value", example = "1", required = true)
        int pageNumber,

        @ApiModelProperty(value = "Page size - positive value", example = "1", required = true)
        int pageSize
) {
}
