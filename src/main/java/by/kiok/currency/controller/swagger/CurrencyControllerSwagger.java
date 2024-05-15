package by.kiok.currency.controller.swagger;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.dto.response.ErrorResponseDto;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
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

@Api(tags = "Currency-controller")
public interface CurrencyControllerSwagger {

    @ApiOperation(
            httpMethod = "GET",
            value = "Get all currencies ordered by title")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNumber", value = "Page number - positive value", example = "1", required = true),
        @ApiImplicitParam(name = "pageSize", value = "Page size - positive value", example = "1", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(
                    response = PageCurrencyResponseDto.class,
                    code = 200,
                    message = "OK"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 400,
                    message = "Validation Error")
    })
    @ResponseBody
    PageCurrencyResponseDto getAllCurrenciesOrderedByTitle(@RequestParam int pageNumber,
                                                           @RequestParam int pageSize);

    @ApiOperation(
            httpMethod = "GET",
            value = "Get currency by id")
    @ApiParam(name = "id", value = "Currency id - min=1", defaultValue = "1", required = true)
    @ApiResponses(value = {
            @ApiResponse(
                    response = CurrencyResponseDto.class,
                    code = 200,
                    message = "OK"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 404,
                    message = "Not found entity by id")
    })
    @ResponseBody
    CurrencyResponseDto getCurrencyById(@PathVariable long id);

    @ApiOperation(
            httpMethod = "POST",
            value = "Create new currency")
    @ApiResponses(value = {
            @ApiResponse(
                    response = CurrencyResponseDto.class,
                    code = 201,
                    message = "Created"),
            @ApiResponse(
                    response = ErrorResponseDto.class,
                    code = 400,
                    message = "Validation Error")
    })
    @ResponseBody
    CurrencyResponseDto createNewCurrency(@RequestBody CurrencyRequestDto currencyRequestDto);
}
