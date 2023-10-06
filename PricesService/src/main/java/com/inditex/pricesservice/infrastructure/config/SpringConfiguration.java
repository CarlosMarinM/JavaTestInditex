package com.inditex.pricesservice.infrastructure.config;

import com.inditex.pricesservice.application.ports.input.PricePort;
import com.inditex.pricesservice.application.ports.output.PricePersistencePort;
import com.inditex.pricesservice.application.usecases.PriceService;
import com.inditex.pricesservice.infrastructure.adapters.output.persistence.PricePersistenceAdapter;
import com.inditex.pricesservice.infrastructure.adapters.output.persistence.PriceSpringRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.inditex.pricesservice.application", "com.inditex.pricesservice.infrastructure"})
public class SpringConfiguration {

    @Bean
    public PricePort pricePort(PriceSpringRepository priceSpringRepository) {
        return new PriceService(pricePersistencePort(priceSpringRepository));
    }

    @Bean
    public PricePersistencePort pricePersistencePort(PriceSpringRepository priceSpringRepository) {
        return new PricePersistenceAdapter(priceSpringRepository);
    }
}
