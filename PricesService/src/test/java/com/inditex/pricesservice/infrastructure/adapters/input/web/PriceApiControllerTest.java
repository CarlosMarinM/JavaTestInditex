package com.inditex.pricesservice.infrastructure.adapters.input.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class PriceApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void givenProductIdBrandIdDate2020_06_14AndHour10_00_whenPriceGetRequest_thenReturnOnePriceObject() throws Exception {
        // Given
        String issueDate = "2020-06-14T10:00:00Z";
        String productId = "35455";
        String brandId = "1";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("issueDate", issueDate)
                        .param("productId", productId)
                        .param("brandId", brandId))

        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[0].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[0].priceList", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2020-06-14T00:00:00Z")))
                .andExpect(jsonPath("$[0].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[0].price", is(35.5)));
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void givenProductIdBrandIdDate2020_06_14AndHour16_00_whenPriceGetRequest_thenReturnTwoPriceObjects() throws Exception {
        // Given
        String issueDate = "2020-06-14T16:00:00Z";
        String productId = "35455";
        String brandId = "1";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("issueDate", issueDate)
                        .param("productId", productId)
                        .param("brandId", brandId))

        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[0].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[0].priceList", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2020-06-14T00:00:00Z")))
                .andExpect(jsonPath("$[0].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[0].price", is(35.5)))
                .andExpect(jsonPath("$[1].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[1].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[1].priceList", is(2)))
                .andExpect(jsonPath("$[1].startDate", is("2020-06-14T15:00:00Z")))
                .andExpect(jsonPath("$[1].endDate", is("2020-06-14T18:30:00Z")))
                .andExpect(jsonPath("$[1].price", is(25.45)));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void givenProductIdBrandIdDate2020_06_14AndHour21_00_whenPriceGetRequest_thenReturnOnePriceObject() throws Exception {
        // Given
        String issueDate = "2020-06-14T21:00:00Z";
        String productId = "35455";
        String brandId = "1";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("issueDate", issueDate)
                        .param("productId", productId)
                        .param("brandId", brandId))

        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[0].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[0].priceList", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2020-06-14T00:00:00Z")))
                .andExpect(jsonPath("$[0].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[0].price", is(35.5)));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void givenProductIdBrandIdDate2020_06_15AndHour10_00_whenPriceGetRequest_thenReturnTwoPriceObjects() throws Exception {
        // Given
        String issueDate = "2020-06-15T10:00:00Z";
        String productId = "35455";
        String brandId = "1";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("issueDate", issueDate)
                        .param("productId", productId)
                        .param("brandId", brandId))

        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[0].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[0].priceList", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2020-06-14T00:00:00Z")))
                .andExpect(jsonPath("$[0].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[0].price", is(35.5)))
                .andExpect(jsonPath("$[1].productId", is(Integer.parseInt(productId))))
                .andExpect(jsonPath("$[1].brandId", is(Integer.parseInt(brandId))))
                .andExpect(jsonPath("$[1].priceList", is(3)))
                .andExpect(jsonPath("$[1].startDate", is("2020-06-15T00:00:00Z")))
                .andExpect(jsonPath("$[1].endDate", is("2020-06-15T11:00:00Z")))
                .andExpect(jsonPath("$[1].price", is(30.5)));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void givenProductIdBrandIdDate2020_06_16AndHour21_00_whenPriceGetRequest_thenReturnTwoPriceObjects() throws Exception {
        // Given
        String issueDate = "2020-06-16T21:00:00Z";
        String productId = "35455";
        String brandId = "1";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("issueDate", issueDate)
                        .param("productId", productId)
                        .param("brandId", brandId))

        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].productId", is(35455)))
                .andExpect(jsonPath("$[0].brandId", is(1)))
                .andExpect(jsonPath("$[0].priceList", is(1)))
                .andExpect(jsonPath("$[0].startDate", is("2020-06-14T00:00:00Z")))
                .andExpect(jsonPath("$[0].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[0].price", is(35.5)))
                .andExpect(jsonPath("$[1].productId", is(35455)))
                .andExpect(jsonPath("$[1].brandId", is(1)))
                .andExpect(jsonPath("$[1].priceList", is(4)))
                .andExpect(jsonPath("$[1].startDate", is("2020-06-15T16:00:00Z")))
                .andExpect(jsonPath("$[1].endDate", is("2020-12-31T23:59:59Z")))
                .andExpect(jsonPath("$[1].price", is(38.95)));
    }
}
