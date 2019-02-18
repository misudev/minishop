package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Cart;
import my.example.minishop.security.ShopSecurityUser;
import my.example.minishop.service.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("")
    public String cart(Authentication authentication, Model model ){
        ShopSecurityUser user = (ShopSecurityUser)authentication.getPrincipal();
        System.out.println("userid : "+user.getId());
        model.addAttribute("carts", cartService.getCartByUser(user.getId()));
        return "cart";
    }

    @PostMapping("")
    public String cart(@RequestParam(name = "userId") Long userId,
                       @RequestParam(name = "itemId") Long itemId,
                       @RequestParam(name = "count") int count){

        Cart cart = new Cart();
        cart.setQuantity(count);
        cart.setUserId(userId);

        cartService.addCart(cart, itemId);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{cartId}")
    public String deleteCart(@PathVariable(name = "cartId") Long cartId){
        cartService.deleteCart(cartId);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam(name = "cartId") List<Long> cartIds,
                             @RequestParam(name = "quantity") List<Integer> quantities){

        int length = cartIds.size();
        for(int i =0; i < length; i++){
            cartService.updateCart(cartIds.get(i), quantities.get(i));
        }

        return "redirect:/cart";
    }
}
