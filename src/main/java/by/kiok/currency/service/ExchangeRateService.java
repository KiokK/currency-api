package by.kiok.currency.service;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;

public interface ExchangeRateService {

    ExchangeRateResponseDto create(ExchangeRateRequestDto createDto);

    ExchangeRateResponseDto findById(long id) throws ModelEntityNotFountException;

    PageExchangeRateResponseDto findAll(CustomPageable pageable);
}
