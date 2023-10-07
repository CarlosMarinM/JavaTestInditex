package com.inditex.pricesservice.infrastructure.adapters.output.persistence;

import com.inditex.pricesservice.domain.PriceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class PriceMapperTest {

    @Test
    void givenPriceEntityObject_whenPriceMapperEntityToDomain_thenReturnPriceResponseObject() {
        // Given
        PriceEntity priceEntity = Mockito.mock(PriceEntity.class);
        given(priceEntity.getProductId()).willReturn(123L);
        given(priceEntity.getBrandId()).willReturn(456);
        given(priceEntity.getPriceList()).willReturn(789);
        given(priceEntity.getStartDate()).willReturn(LocalDateTime.of(2022, 1, 1, 0, 0));
        given(priceEntity.getEndDate()).willReturn(LocalDateTime.of(2022, 1, 31, 23, 59));
        given(priceEntity.getPrice()).willReturn(BigDecimal.valueOf(99.99));

        // When
        PriceResponse priceResponse = PriceMapper.entityToDomain(priceEntity);

        // Then
        assertThat(priceResponse.getProductId()).isEqualTo(123);
        assertThat(priceResponse.getBrandId()).isEqualTo(456);
        assertThat(priceResponse.getPriceList()).isEqualTo(789);
        assertThat(priceResponse.getStartDate().toLocalDateTime()).isEqualTo(LocalDateTime.of(2022, 1, 1, 0, 0));
        assertThat(priceResponse.getEndDate().toLocalDateTime()).isEqualTo(LocalDateTime.of(2022, 1, 31, 23, 59));
        assertThat(priceResponse.getPrice()).isEqualTo(BigDecimal.valueOf(99.99));
    }
}
