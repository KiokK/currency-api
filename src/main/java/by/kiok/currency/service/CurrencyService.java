package by.kiok.currency.service;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;

public interface CurrencyService {

    CurrencyResponseDto create(CurrencyRequestDto createDto);

    CurrencyResponseDto findById(long id) throws ModelEntityNotFountException;

    PageCurrencyResponseDto findAllOrderedByTitle(CustomPageable pageable);
}
