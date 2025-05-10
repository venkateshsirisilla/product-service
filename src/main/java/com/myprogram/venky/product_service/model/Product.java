package com.myprogram.venky.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private String id;
    private String name;
    private String description;
    private Long price;
}
