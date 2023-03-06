package me.kimunz.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long productId;
    private String productType;
    private String productName;
    private String description;
    private int stock;
    private int price;

}
