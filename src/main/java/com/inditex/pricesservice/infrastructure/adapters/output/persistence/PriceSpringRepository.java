package com.inditex.pricesservice.infrastructure.adapters.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceSpringRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.brandId = :brandId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId")
    List<PriceEntity> findByCustomFilter(@Param("brandId") Integer brandId, @Param("date") LocalDateTime date, @Param("productId") Long productId);

}
