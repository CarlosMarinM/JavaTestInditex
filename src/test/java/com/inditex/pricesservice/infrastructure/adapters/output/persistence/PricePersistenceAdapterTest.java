package com.inditex.pricesservice.infrastructure.adapters.output.persistence;

import com.inditex.pricesservice.application.ports.output.PricePersistencePort;
import com.inditex.pricesservice.domain.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PricePersistenceAdapterTest {

    private static final PriceEntity PRICE_ENTITY = PriceEntity.builder()
            .startDate(LocalDateTime.now())
            .endDate(LocalDateTime.now())
            .build();

    private PricePersistencePort pricePersistencePort;

    @Mock
    private PriceSpringRepository priceSpringRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pricePersistencePort = new PricePersistenceAdapter(priceSpringRepository);
    }

    @Test
    @DisplayName("Given valid parameters, When getPrices is called, Then return list of PriceResponse")
    void givenValidParameters_whenGetPrices_thenReturnListOfPriceResponse() {
        // Given
        Integer brandId = 1;
        LocalDateTime date = LocalDateTime.of(2023, 10, 6, 12, 0);
        Long productId = 1234L;

        List<PriceEntity> priceEntities = new ArrayList<>() {{
            add(PRICE_ENTITY);
            add(PRICE_ENTITY);
        }};

        given(priceSpringRepository.findByCustomFilter(brandId, date, productId))
                .willReturn(priceEntities);

        // When
        List<PriceResponse> result = pricePersistencePort.getPrices(brandId, date, productId);

        // Then
        verify(priceSpringRepository, times(1)).findByCustomFilter(brandId, date, productId);
        assertEquals(priceEntities.size(), result.size());
    }

}
