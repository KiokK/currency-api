package by.kiok.currency.service.impl;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;
import by.kiok.currency.mapstruct.CurrencyMapper;
import by.kiok.currency.model.Currency;
import by.kiok.currency.repository.CurrencyRepository;
import by.kiok.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    private final CurrencyMapper currencyMapper;

    @Override
    public CurrencyResponseDto create(CurrencyRequestDto createDto) {
        Currency created = currencyMapper.toCurrency(createDto);
        created = currencyRepository.create(created);

        return currencyMapper.toCurrencyResponseDto(created);
    }

    @Override
    public CurrencyResponseDto findById(long id) throws ModelEntityNotFountException {
        return currencyRepository.findById(id)
                .map(currencyMapper::toCurrencyResponseDto)
                .orElseThrow(() -> new ModelEntityNotFountException(id));
    }

    @Override
    public PageCurrencyResponseDto findAllOrderedByTitle(CustomPageable pageable) {
        return currencyMapper.toPageCurrencyResponseDto(
                currencyRepository.findAllOrderedByTitle(pageable),
                pageable);
    }
}
