package by.kiok.currency.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import static by.kiok.currency.dto.ValidateDtoConstants.DATA_FORMAT;

@ApiModel(description = "Exchange rate response example")
public record ExchangeRateResponseDto(

        @ApiModelProperty(value = "id", example = "1", required = true)
        long id,

        @ApiModelProperty(value = "initialCurrencyId", example = "1", required = true)
        long initialCurrencyId,

        @ApiModelProperty(example = "USD", required = true)
        String initialMoneySign,

        @ApiModelProperty(value = "concludingCurrencyId", example = "2", required = true)
        long concludingCurrencyId,

        @ApiModelProperty(example = "BUN", required = true)
        String concludingMoneySign,

        @ApiModelProperty(example = "1", required = true)
        int initialAmount,

        @ApiModelProperty(example = "1", required = true)
        int concludingAmount,

        @ApiModelProperty(example = "3.33", required = true)
        double rate,

        @ApiModelProperty(example = "2024-05-11T10:33:22.123", required = true)
        @JsonFormat(pattern = DATA_FORMAT)
        LocalDateTime modifiedAt
) {
}
