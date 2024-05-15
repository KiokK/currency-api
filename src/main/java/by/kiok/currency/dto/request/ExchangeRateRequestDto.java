package by.kiok.currency.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import static by.kiok.currency.dto.ValidateDtoConstants.EXCHANGE_RATE_RATE_MAX_DECIMAL;
import static by.kiok.currency.dto.ValidateDtoConstants.EXCHANGE_RATE_RATE_MIN_DECIMAL;

@ApiModel(description = "Exchange rate request example")
public record ExchangeRateRequestDto (

        @ApiModelProperty(value = "min=1", example = "1", required = true)
        @Min(1)
        long initialCurrencyId,

        @ApiModelProperty(value = "min=1", example = "2", required = true)
        @Min(1)
        long concludingCurrencyId,

        @ApiModelProperty(value = "min=1", example = "1.25", required = true)
        @Min(1)
        int initialAmount,

        @ApiModelProperty(value = "min=1", example = "1", required = true)
        @Min(1)
        int concludingAmount,

        @ApiModelProperty(value = "value["+EXCHANGE_RATE_RATE_MIN_DECIMAL+".." + EXCHANGE_RATE_RATE_MAX_DECIMAL + "]",
                example = "1.25", required = true)
        @DecimalMin(EXCHANGE_RATE_RATE_MIN_DECIMAL)
        @DecimalMax(EXCHANGE_RATE_RATE_MAX_DECIMAL)
        double rate
) {
}
