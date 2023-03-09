package me.kimunz.project.controller;

import me.kimunz.project.dto.CartDto;
import me.kimunz.project.entity.Cart;
import me.kimunz.project.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List> getCartList(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartList(userId));
    }

    @PostMapping("/cart")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Object> addCart(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok(cartService.addCart(cartDto));
    }
}
