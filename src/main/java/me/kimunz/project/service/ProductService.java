package me.kimunz.project.service;

import me.kimunz.project.entity.Product;
import me.kimunz.project.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Optional<Product> getProductById(String id) {
        return productMapper.getProductById(id);
    }
}
