package com.inditex.pricesservice.application.usecases;


import com.inditex.pricesservice.application.ports.input.PricePort;
import com.inditex.pricesservice.application.ports.output.PricePersistencePort;
import com.inditex.pricesservice.domain.PriceResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public class PriceService implements PricePort {

    private final PricePersistencePort pricePersistencePort;

    public PriceService(final PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    @Override
    public ResponseEntity<List<PriceResponse>> findPrices(final OffsetDateTime issueDate, final Long productId, final Integer brandId) {
        LocalDateTime date = Optional.ofNullable(issueDate).map(OffsetDateTime::toLocalDateTime).orElse(null);
        List<PriceResponse> prices = pricePersistencePort.getPrices(brandId, date, productId);

        if (prices.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(prices);
    }

}
