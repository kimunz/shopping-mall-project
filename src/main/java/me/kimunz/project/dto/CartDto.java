package me.kimunz.project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private int count;
}
