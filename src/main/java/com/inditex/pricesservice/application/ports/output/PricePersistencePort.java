package com.inditex.pricesservice.application.ports.output;

import com.inditex.pricesservice.domain.PriceResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePersistencePort {

    List<PriceResponse> getPrices(Integer brandId, LocalDateTime date, Long productId);
}
