package me.kimunz.project.mapper;

import me.kimunz.project.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProductMapper {

    Optional<Product> getProductById(String id);
}
