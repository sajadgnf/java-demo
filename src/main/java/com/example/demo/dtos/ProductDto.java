package com.example.demo.dtos;

import com.example.demo.enitities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;

    public static ProductDto from(Product product) {
        if (product == null) return null;
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
