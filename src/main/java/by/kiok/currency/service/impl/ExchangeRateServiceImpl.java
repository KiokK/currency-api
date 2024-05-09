package by.kiok.currency.service.impl;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;
import by.kiok.currency.mapstruct.ExchangeRateMapper;
import by.kiok.currency.model.ExchangeRate;
import by.kiok.currency.repository.ExchangeRateRepository;
import by.kiok.currency.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    private final ExchangeRateMapper exchangeRateMapper;

    @Override
    public ExchangeRateResponseDto create(ExchangeRateRequestDto createDto) {
        ExchangeRate exchangeRate = exchangeRateMapper.toExchangeRate(createDto);
        exchangeRate = exchangeRateRepository.create(exchangeRate);

        return exchangeRateMapper.toExchangeRateResponseDto(exchangeRate);
    }

    @Override
    public ExchangeRateResponseDto findById(long id) throws ModelEntityNotFountException {
        return exchangeRateRepository.findById(id)
                .map(exchangeRateMapper::toExchangeRateResponseDto)
                .orElseThrow(() -> new ModelEntityNotFountException(id));
    }

    @Override
    public PageExchangeRateResponseDto findAll(CustomPageable pageable) {
        return exchangeRateMapper.toPageExchangeRateResponseDto(
                exchangeRateRepository.findAll(pageable),
                pageable);
    }
}
