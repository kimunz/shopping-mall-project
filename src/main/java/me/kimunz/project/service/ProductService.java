package me.kimunz.project.service;

import me.kimunz.project.dto.ProductDto;
import me.kimunz.project.entity.Product;
import me.kimunz.project.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
    public Optional<Product> getProductById(Long productId) {
        return productMapper.getProductById(productId);
    }

    public int addProduct(ProductDto productDto) {
        return productMapper.addProduct(productDto);
    }

    public int updateProduct(Long productId, ProductDto productDto) {
        return productMapper.updateProduct(productId, productDto);
    }

    public int deleteProduct(Long productId) {
        return productMapper.deleteProduct(productId);
    }
}
