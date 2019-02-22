package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.*;
import my.example.minishop.dto.OrderDto;
import my.example.minishop.security.ShopSecurityUser;
import my.example.minishop.service.CartService;
import my.example.minishop.service.OrderDetailService;
import my.example.minishop.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    @PostMapping("/orderform")
      public String orderform(@RequestParam(name = "selected")Long[] cartIds,
                          Model model){
            //수정 필요 **
            Category allCategory = new Category();
            allCategory.setId(0L);
            allCategory.setName("shop all");
            model.addAttribute("selectedCategory", allCategory);

            List<Cart> carts = new ArrayList<>();
            Cart cart = null;
            for(Long id : cartIds){
                cart = cartService.getCartById(id);
                if(cart!=null)
                    carts.add(cart);
            }
            model.addAttribute("carts", carts);

            Long totalPrice = 0L;
            for(Cart c : carts){
                totalPrice += c.getItem().getPrice() * c.getQuantity();
            }
            model.addAttribute("totalPrice", totalPrice);
            //return "checkout1";
            return "checkout";
        }


    @PostMapping
    public String order(@ModelAttribute OrderDto orderDto, Authentication authentication){
        System.out.println(orderDto.toString());

        ShopSecurityUser user = (ShopSecurityUser)authentication.getPrincipal();

        Order newOrder = new Order();
        newOrder.setUserId(user.getId());
        newOrder.setStatus("입금전");
        newOrder.setUserName(orderDto.getUserName());
        newOrder.setAddressZip(orderDto.getAddressZip());
        newOrder.setAddress(orderDto.getAddress());
        newOrder.setDetailAddress(orderDto.getDetailAddress());
        newOrder.setExtraAddress(orderDto.getExtraAddress());
        newOrder.setContact(orderDto.getConcat());
        newOrder.setMemo(orderDto.getMemo());
        newOrder.setPaymentType("무통장 입금");

        for(Long cartId : orderDto.getCartId()){
            Cart cart = cartService.getCartById(cartId);
            OrderDetail orderDetail = new OrderDetail();
            Item item = cart.getItem();
            orderDetail.setItemId(item.getId());
            orderDetail.setItemName(item.getName());
            orderDetail.setItemPrice(item.getPrice());
            orderDetail.setOrderQuantity(cart.getQuantity());
            orderDetail.setItemPhoneType(cart.getPhoneType());
            newOrder.addOrderDetail(orderDetailService.addOrderDetail(orderDetail));
        }

        orderService.addOrder(newOrder);

        return "thankyou";
    }


}
