package by.kiok.currency.dto.response;

import io.swagger.annotations.ApiModelProperty;

public record ErrorResponseDto(

        @ApiModelProperty(value = "Error message", example = "Entity by id not found", required = true)
        String message,

        @ApiModelProperty(value = "Server error code", example = "400001", required = true)
        int code
) {
}
