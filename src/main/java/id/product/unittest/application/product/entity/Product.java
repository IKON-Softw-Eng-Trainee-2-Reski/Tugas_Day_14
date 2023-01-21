package id.product.unittest.application.product.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    @NotEmpty(message = "Product is required")
    private String name;
    @NotEmpty(message = "Product description is required")
    private String description;

    private int stock;
    private int price;
}
