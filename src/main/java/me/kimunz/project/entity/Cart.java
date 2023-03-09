package me.kimunz.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Long cartId;
    private Long userId;
    private Long productId;
    private int count;
}
