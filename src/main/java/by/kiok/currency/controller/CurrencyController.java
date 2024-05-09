package by.kiok.currency.controller;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody PageCurrencyResponseDto getAllCurrenciesOrderedByTitle(CustomPageable pageable) {
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
        return currencyService.create(currencyRequestDto);
    }
}
