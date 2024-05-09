package by.kiok.currency.mapstruct;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrencyMapper {

    Currency toCurrency(CurrencyRequestDto currencyRequestDto);

    CurrencyResponseDto toCurrencyResponseDto(Currency currency);

    @Mapping(target = "currencies", source = "currencies")
    @Mapping(target = "pageNumber", source = "pageable.pageNumber")
    @Mapping(target = "pageSize", source = "pageable.pageSize")
    PageCurrencyResponseDto toPageCurrencyResponseDto(List<Currency> currencies, CustomPageable pageable);
}
