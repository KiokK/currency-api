package by.kiok.currency.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Currency response example")
public record CurrencyResponseDto (

        @ApiModelProperty(value = "Currency id", example = "1", required = true)
        long id,

        @ApiModelProperty(value = "Currency title", example = "US Dollar", required = true)
        String title,

        @ApiModelProperty(value = "Currency money sign", example = "USD", required = true)
        String moneySign
){
}
