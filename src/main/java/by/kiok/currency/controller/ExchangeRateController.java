package by.kiok.currency.controller;

import by.kiok.currency.controller.swagger.ExchangeRateControllerSwagger;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import by.kiok.currency.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static by.kiok.currency.validator.ValidatorUtil.validate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchangeRates")
public class ExchangeRateController implements ExchangeRateControllerSwagger {

    private final ExchangeRateService exchangeRateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody PageExchangeRateResponseDto getAllExchangeRates(@RequestParam int pageNumber,
                                                                         @RequestParam int pageSize) {
        CustomPageable pageable = new CustomPageable(pageNumber, pageSize);
        validate(pageable);
        return exchangeRateService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ExchangeRateResponseDto getExchangeRateById(@PathVariable long id) {
        return exchangeRateService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ExchangeRateResponseDto createExchangeRate(@RequestBody ExchangeRateRequestDto createDto) {
        validate(createDto);
        return exchangeRateService.create(createDto);
    }
}
