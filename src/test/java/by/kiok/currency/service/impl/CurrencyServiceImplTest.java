package by.kiok.currency.service.impl;

import by.kiok.currency.dto.request.CurrencyRequestDto;
import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.response.CurrencyResponseDto;
import by.kiok.currency.dto.response.PageCurrencyResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;
import by.kiok.currency.mapstruct.CurrencyMapper;
import by.kiok.currency.model.Currency;
import by.kiok.currency.repository.CurrencyRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static by.kiok.currency.util.CurrencyRequestDtoTestData.getCurrencyRequestDto;
import static by.kiok.currency.util.CurrencyResponseDtoTestData.getCurrencyResponseDtoListSize2;
import static by.kiok.currency.util.CurrencyResponseDtoTestData.getCurrencyResponseDtoUsd;
import static by.kiok.currency.util.CurrencyTestData.getCurrencies;
import static by.kiok.currency.util.CurrencyTestData.getCurrencyUsd;
import static by.kiok.currency.util.CurrencyTestData.getCurrencyIdNull;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.NO_EXISTS_ID;
import static by.kiok.currency.util.TestConstants.PAGE_NUMBER_1;
import static by.kiok.currency.util.TestConstants.PAGE_SIZE_2;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Mock
    private CurrencyRepository currencyRepository;

    @Spy
    private CurrencyMapper currencyMapper = Mappers.getMapper(CurrencyMapper.class);

    @Nested
    class Create {

        @Test
        void checkCreateShouldReturnCreatedCurrency() {
            //given
            CurrencyRequestDto createDto = getCurrencyRequestDto();
            Currency newCurrency = getCurrencyIdNull();
            Currency createdCurrency = getCurrencyUsd();
            CurrencyResponseDto expected = getCurrencyResponseDtoUsd();

            //when
            when(currencyRepository.create(newCurrency))
                    .thenReturn(createdCurrency);
            CurrencyResponseDto actual = currencyService.create(createDto);

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FindById {

        @Test
        void checkFindByIdShouldReturnFoundCurrency() {
            //given
            Currency foundCurrency = getCurrencyUsd();
            CurrencyResponseDto expected = getCurrencyResponseDtoUsd();

            //when
            when(currencyRepository.findById(DEFAULT_ID_1))
                    .thenReturn(Optional.of(foundCurrency));
            CurrencyResponseDto actual = currencyService.findById(DEFAULT_ID_1);

            //then
            assertEquals(expected, actual);
        }

        @Test
        void checkFindByIdShouldThrowNotFoundException() {
            //given //when
            when(currencyRepository.findById(NO_EXISTS_ID))
                    .thenReturn(Optional.empty());
            //then
            assertThrows(ModelEntityNotFountException.class,
                    () -> currencyService.findById(NO_EXISTS_ID));
        }
    }

    @Nested
    class FindAllOrderedByTitle {

        @Test
        void checkFindAllOrderedByTitle() {
            //given
            CustomPageable pageable = new CustomPageable(PAGE_NUMBER_1, PAGE_SIZE_2);
            List<CurrencyResponseDto> expected = getCurrencyResponseDtoListSize2();

            //when
            when(currencyRepository.findAllOrderedByTitle(pageable))
                    .thenReturn(getCurrencies());
            PageCurrencyResponseDto actual = currencyService.findAllOrderedByTitle(pageable);

            //then
            assertAll(
                    () -> assertEquals(PAGE_NUMBER_1, actual.pageNumber()),
                    () -> assertEquals(PAGE_SIZE_2, actual.pageSize()),
                    () -> assertEquals(expected, actual.currencies())
            );
        }
    }
}
