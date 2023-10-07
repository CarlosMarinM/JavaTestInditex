package com.inditex.pricesservice.infrastructure.adapters.output.persistence;

import com.inditex.pricesservice.domain.PriceResponse;

import java.time.ZoneOffset;

public class PriceMapper {

    private PriceMapper (){}

    public static PriceResponse entityToDomain(final PriceEntity priceEntity) {
        return new PriceResponse()
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .priceList(priceEntity.getPriceList())
                .startDate(priceEntity.getStartDate().atOffset(ZoneOffset.UTC))
                .endDate(priceEntity.getEndDate().atOffset(ZoneOffset.UTC))
                .price(priceEntity.getPrice());
    }

}
