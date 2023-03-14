package me.kimunz.project.mapper;

import me.kimunz.project.dto.CartDto;
import me.kimunz.project.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<Cart> getCartList(Long userId);

    int addCart(CartDto cartDto);

    Object deleteCart(Long cartId);
}
