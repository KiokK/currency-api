package by.kiok.currency.mapstruct;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import by.kiok.currency.model.ExchangeRate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExchangeRateMapper {

    @Mapping(target = "initial.id", source = "initialCurrencyId")
    @Mapping(target = "concluding.id", source = "concludingCurrencyId")
    ExchangeRate toExchangeRate(ExchangeRateRequestDto exchangeRateRequestDto);

    @Mapping(target = "initialCurrencyId", source = "initial.id")
    @Mapping(target = "concludingCurrencyId", source = "concluding.id")
    @Mapping(target = "concludingMoneySign", source = "concluding.moneySign")
    @Mapping(target = "initialMoneySign", source = "initial.moneySign")
    ExchangeRateResponseDto toExchangeRateResponseDto(ExchangeRate exchangeRate);

    PageExchangeRateResponseDto toPageExchangeRateResponseDto(List<ExchangeRate> exchangeRates, CustomPageable pageable);
}
