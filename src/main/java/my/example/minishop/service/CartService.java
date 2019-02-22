package my.example.minishop.service;

import my.example.minishop.domain.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getCartByUser(Long userId);
    public void addCart(Cart cart, Long itemId, String phoneType);
    public void deleteCart(Long cartId);
    public void updateCart(Long cartId, int quantity);
    public Cart getCartById(Long cartId);
}
