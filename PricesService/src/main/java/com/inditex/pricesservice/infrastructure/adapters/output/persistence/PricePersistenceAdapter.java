package com.inditex.pricesservice.infrastructure.adapters.output.persistence;

import com.inditex.pricesservice.application.ports.output.PricePersistencePort;
import com.inditex.pricesservice.domain.PriceResponse;

import java.time.LocalDateTime;
import java.util.List;

public class PricePersistenceAdapter implements PricePersistencePort {

    private final PriceSpringRepository priceRepository;

    public PricePersistenceAdapter(final PriceSpringRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<PriceResponse> getPrices(final Integer brandId, final LocalDateTime date, final Long productId) {
        return priceRepository.findByCustomFilter(brandId, date, productId)
                .stream()
                .map(PriceMapper::entityToDomain)
                .toList();
    }

}
