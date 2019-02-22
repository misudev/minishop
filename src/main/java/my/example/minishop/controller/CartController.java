package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Cart;
import my.example.minishop.domain.Category;
import my.example.minishop.security.ShopSecurityUser;
import my.example.minishop.service.CartService;
import my.example.minishop.service.CategoryService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CategoryService categoryService;
    private final CartService cartService;

    @GetMapping("/cart")
    public String cart(Authentication authentication, Model model ){

        List<Category> categories = categoryService.getCategoryAll();
        model.addAttribute("categories", categories);


        ShopSecurityUser user = (ShopSecurityUser)authentication.getPrincipal();
        List<Cart> carts = cartService.getCartByUser(user.getId());
        model.addAttribute("carts", cartService.getCartByUser(user.getId()));



        //수정 필요 **
        Category allCategory = new Category();
        allCategory.setId(0L);
        allCategory.setName("shop all");
        model.addAttribute("selectedCategory", allCategory);


        return "cart";
    }

    @PostMapping("/cart")
    public String cart(){
        return "checkout";
    }
}
