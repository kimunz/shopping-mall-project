package me.kimunz.project.service;

import me.kimunz.project.dto.CartDto;
import me.kimunz.project.entity.Cart;
import me.kimunz.project.mapper.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<Cart> getCartList(Long userId) {
        return cartMapper.getCartList(userId);
    }

    public int addCart(CartDto cartDto) {
        return cartMapper.addCart(cartDto);
    }
}
