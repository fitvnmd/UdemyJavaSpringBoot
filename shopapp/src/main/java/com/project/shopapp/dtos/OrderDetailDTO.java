package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "order's ID must be >= 1")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "Product's ID must be >= 1")
    private Long productId;

    @Min(value = 1, message = "Price's ID must be >= 1")
    private Long price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "number_of_products's ID must be >=1")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "total_money's ID must be > 0")
    private int totalMoney;

    private String color;
}
