package me.kimunz.project.mapper;

import me.kimunz.project.dto.ProductDto;
import me.kimunz.project.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

    List<Product> getProductList();
    Optional<Product> getProductById(Long productId);
    int addProduct(ProductDto productDto);
}
