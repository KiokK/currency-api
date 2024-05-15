package by.kiok.currency.controller.swagger;

import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ErrorResponseDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "ExchangeRate-controller")
public interface ExchangeRateControllerSwagger {

    @ApiOperation(
            httpMethod = "GET",
            value = "Get all exchange rates")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "Page number - positive value", example = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "Page size - positive value", example = "1", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(
                    response = PageExchangeRateResponseDto.class,
                    code = 200,
                    message = "OK"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 400,
                    message = "Validation Error")
    })
    @ResponseBody
    PageExchangeRateResponseDto getAllExchangeRates(@RequestParam int pageNumber,
                                                    @RequestParam int pageSize);

    @ApiOperation(
            httpMethod = "GET",
            value = "Get exchange rate by id")
    @ApiParam(name = "id", value = "Exchange rate id - min=1", defaultValue = "1", required = true)
    @ApiResponses(value = {
            @ApiResponse(
                    response = ExchangeRateResponseDto.class,
                    code = 200,
                    message = "OK"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 404,
                    message = "Not found entity by id")
    })
    @ResponseBody
    ExchangeRateResponseDto getExchangeRateById(@PathVariable long id);

    @ApiOperation(
            httpMethod = "POST",
            value = "Create new exchange rate")
    @ApiResponses(value = {
            @ApiResponse(
                    response = ExchangeRateResponseDto.class,
                    code = 201,
                    message = "Created"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 400,
                    message = "Validation Error")
    })
    @ResponseBody
    ExchangeRateResponseDto createExchangeRate(@RequestBody ExchangeRateRequestDto createDto);
}
