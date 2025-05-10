package com.myprogram.venky.product_service.service;

import com.myprogram.venky.product_service.dto.ProductRequest;
import com.myprogram.venky.product_service.dto.ProductResponse;
import com.myprogram.venky.product_service.model.Product;
import com.myprogram.venky.product_service.repostiory.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .description(productRequest.getDescription())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
}
