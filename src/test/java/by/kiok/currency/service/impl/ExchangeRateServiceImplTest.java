package by.kiok.currency.service.impl;

import by.kiok.currency.dto.request.CustomPageable;
import by.kiok.currency.dto.request.ExchangeRateRequestDto;
import by.kiok.currency.dto.response.ExchangeRateResponseDto;
import by.kiok.currency.dto.response.PageExchangeRateResponseDto;
import by.kiok.currency.exception.ModelEntityNotFountException;
import by.kiok.currency.mapstruct.ExchangeRateMapper;
import by.kiok.currency.model.ExchangeRate;
import by.kiok.currency.repository.ExchangeRateRepository;
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

import static by.kiok.currency.util.ExchangeRateRequestDtoTestData.getExchangeRateRequestDto;
import static by.kiok.currency.util.ExchangeRateResponseDtoTestData.getExchangeRateResponseDto;
import static by.kiok.currency.util.ExchangeRateTestData.getExchangeRate;
import static by.kiok.currency.util.ExchangeRateTestData.getExchangeRateNullId;
import static by.kiok.currency.util.TestConstants.DEFAULT_ID_1;
import static by.kiok.currency.util.TestConstants.NO_EXISTS_ID;
import static by.kiok.currency.util.TestConstants.PAGE_NUMBER_1;
import static by.kiok.currency.util.TestConstants.PAGE_SIZE_1;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceImplTest {

    @InjectMocks
    private ExchangeRateServiceImpl exchangeRateService;

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @Spy
    private ExchangeRateMapper exchangeRateMapper = Mappers.getMapper(ExchangeRateMapper.class);

    @Nested
    class Create {

        @Test
        void checkCreateShouldReturnCreated() {
            //given
            ExchangeRateRequestDto createDto = getExchangeRateRequestDto();
            ExchangeRate newExchangeRate = getExchangeRateNullId();
            ExchangeRate created = getExchangeRate();
            ExchangeRateResponseDto expected = getExchangeRateResponseDto();

            //when
            doReturn(created).when(exchangeRateRepository)
                    .create(newExchangeRate);
            ExchangeRateResponseDto actual = exchangeRateService.create(createDto);

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FindById {

        @Test
        void checkFindByIdShouldReturnFound() {
            //given
            ExchangeRate found = getExchangeRate();
            ExchangeRateResponseDto expected = getExchangeRateResponseDto();

            //when
            when(exchangeRateRepository.findById(DEFAULT_ID_1))
                    .thenReturn(Optional.of(found));
            ExchangeRateResponseDto actual = exchangeRateService.findById(DEFAULT_ID_1);

            //then
            assertEquals(expected, actual);
        }

        @Test
        void checkFindByIdShouldThrowsNotFoundException() {
            //given //when
            when(exchangeRateRepository.findById(NO_EXISTS_ID))
                    .thenReturn(Optional.empty());
            //then
            assertThrows(ModelEntityNotFountException.class,
                    () -> exchangeRateService.findById(NO_EXISTS_ID));
        }
    }

    @Nested
    class FindAll {

        @Test
        void checkFindAllShouldReturnPageableExchangeRates() {
            //given
            CustomPageable pageable = new CustomPageable(PAGE_NUMBER_1, PAGE_SIZE_1);
            List<ExchangeRateResponseDto> expected = List.of(getExchangeRateResponseDto());
            List<ExchangeRate> exchangeRates = List.of(getExchangeRate());

            //when
            when(exchangeRateRepository.findAll(pageable))
                    .thenReturn(exchangeRates);
            PageExchangeRateResponseDto actual = exchangeRateService.findAll(pageable);

            //then
            assertAll(
                    () -> assertEquals(pageable.pageNumber(), actual.pageNumber()),
                    () -> assertEquals(pageable.pageSize(), actual.pageSize()),
                    () -> assertEquals(expected, actual.exchangeRates())
            );
        }
    }
}
