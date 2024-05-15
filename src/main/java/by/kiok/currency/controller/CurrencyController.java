package by.kiok.currency.controller;

import by.kiok.currency.controller.swagger.CurrencyControllerSwagger;
import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.service.CurrencyService;
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
@RequestMapping("/currencies")
public class CurrencyController implements CurrencyControllerSwagger {

    private final CurrencyService currencyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody PageCurrencyResponseDto getAllCurrenciesOrderedByTitle(@RequestParam int pageNumber,
                                                                                @RequestParam int pageSize) {
        CustomPageable pageable = new CustomPageable(pageNumber, pageSize);
        validate(pageable);
        return currencyService.findAllOrderedByTitle(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody CurrencyResponseDto getCurrencyById(@PathVariable long id) {
        return currencyService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CurrencyResponseDto createNewCurrency(@RequestBody CurrencyRequestDto currencyRequestDto) {
        validate(currencyRequestDto);
        return currencyService.create(currencyRequestDto);
    }
}
