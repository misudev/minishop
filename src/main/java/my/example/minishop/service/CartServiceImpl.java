package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Cart;
import my.example.minishop.domain.Item;
import my.example.minishop.repository.CartRepository;
import my.example.minishop.repository.ItemRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cart> getCartByUser(Long userId) {
        return cartRepository.getCartByUser(userId);
    }

    @Override
    @Transactional
    public void addCart(Cart cart, Long itemId, String phoneType) {
        Cart existCart = cartRepository.getCartByUserAndItemAndPhoneType(cart.getUserId(), itemId, phoneType);

        if(existCart!=null){
            int quantity = cart.getQuantity() + existCart.getQuantity();
            cartRepository.updateCart(quantity, existCart.getId());
        }else{
            Optional<Item> optionalItem
                    = itemRepository.findById(itemId);

            cart.setItem(optionalItem.get());
            cart.setPhoneType(phoneType);
            cartRepository.save(cart);
        }

    }

    @Override
    @Transactional
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    @Transactional
    public void updateCart(Long cartId, int quantity) {
        cartRepository.updateCart(quantity, cartId);
    }


    @Override
    @Transactional
    public Cart getCartById(Long cartId) {
        return cartRepository.getCartById(cartId);
    }
}
