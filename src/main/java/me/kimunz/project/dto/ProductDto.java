package me.kimunz.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String productType;

    @NotNull
    @Size(min = 3, max = 100)
    private String productName;

    @NotNull
    @Size(min = 3, max = 200)
    private String description;

    @NotNull
    @Size(min = 3, max = 50)
    private int stock;

    @NotNull
    @Size(min = 3, max = 50)
    private int price;
}
