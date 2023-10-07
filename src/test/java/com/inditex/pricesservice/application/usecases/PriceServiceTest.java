package com.inditex.pricesservice.application.usecases;

import com.inditex.pricesservice.application.ports.output.PricePersistencePort;
import com.inditex.pricesservice.domain.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    @InjectMocks
    private PriceService priceService;

    @Mock
    private PricePersistencePort pricePersistencePort;

    @Test
    void givenExistPrices_whenFindPrices_thenReturnPrices(){
        // Given
        OffsetDateTime issueDate = OffsetDateTime.now();
        Long productId = 1L;
        Integer brandId = 2;

        List<PriceResponse> prices = Collections.singletonList(new PriceResponse());

        given(pricePersistencePort.getPrices(brandId, issueDate.toLocalDateTime(), productId)).willReturn(prices);

        // When
        ResponseEntity<List<PriceResponse>> responseEntity = priceService.findPrices(issueDate, productId, brandId);

        // Then
        assertEquals(ResponseEntity.ok(prices), responseEntity);
    }

    @Test
    void givenNoExistPrices_whenFindPrices_thenReturnNotFound() {
        // Given
        OffsetDateTime issueDate = OffsetDateTime.now();
        Long productId = 1L;
        Integer brandId = 2;

        given(pricePersistencePort.getPrices(brandId, issueDate.toLocalDateTime(), productId)).willReturn(Collections.emptyList());

        // When
        ResponseEntity<List<PriceResponse>> responseEntity = priceService.findPrices(issueDate, productId, brandId);

        // Then
        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }
}
