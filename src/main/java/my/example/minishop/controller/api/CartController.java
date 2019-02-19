package my.example.minishop.controller.api;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Cart;
import my.example.minishop.dto.CartDto;
import my.example.minishop.dto.CartForm;
import my.example.minishop.security.ShopSecurityUser;
import my.example.minishop.service.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public String addCart(Authentication authentication,
                          @RequestBody CartForm cartForm){

        if(!authentication.isAuthenticated()){
            return "false";
        }

        ShopSecurityUser user = (ShopSecurityUser)authentication.getPrincipal();

        Cart cart = new Cart();
        cart.setQuantity(cartForm.getQuantity());
        cart.setUserId(user.getId());

        cartService.addCart(cart, cartForm.getItemId());
        return "true";
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable(name = "cartId") Long cartId){
        cartService.deleteCart(cartId);

    }

    @PutMapping
    public void updateCart(
                           @RequestBody CartDto cartDto) {

        System.out.println(cartDto.getQuantity());
        cartService.updateCart(cartDto.getCartId(), cartDto.getQuantity());

    }
}
