package me.kimunz.project.controller;

import me.kimunz.project.dto.ProductDto;
import me.kimunz.project.entity.Product;
import me.kimunz.project.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List> getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }

    @PostMapping("/product")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId).get());
    }
}
