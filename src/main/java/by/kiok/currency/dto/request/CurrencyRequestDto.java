package by.kiok.currency.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Size;

import static by.kiok.currency.dto.ValidateDtoConstants.CURRENCY_MONEY_SIGN_SIZE;
import static by.kiok.currency.dto.ValidateDtoConstants.CURRENCY_TITLE_SIZE;

@ApiModel(description = "Currency request example")
public record CurrencyRequestDto(

        @ApiModelProperty(value = "size[1.." + CURRENCY_TITLE_SIZE + "]", example = "US Dollar", required = true)
        @Size(min = 1, max = CURRENCY_TITLE_SIZE)
        String title,

        @ApiModelProperty(value = "size[1.." + CURRENCY_MONEY_SIGN_SIZE + "]", example = "USD", required = true)
        @Size(min = 1, max = CURRENCY_MONEY_SIGN_SIZE)
        String moneySign
) {
}
