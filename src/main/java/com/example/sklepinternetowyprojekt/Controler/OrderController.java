package com.example.sklepinternetowyprojekt.Controler;

import com.example.sklepinternetowyprojekt.ItemOperations;
import com.example.sklepinternetowyprojekt.Service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/order")
public class OrderController {
private final CartService cartService;

    public OrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart(){
        return "cartview";
    }
    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable("itemId") Long itemId ) {
        cartService.itemOperation(itemId, ItemOperations.INCREASE);
        return "cartView";
    }
    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable("itemId") Long itemId ) {
        cartService.itemOperation(itemId,ItemOperations.DECREASE);
        return "cartView";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItem(@PathVariable("itemId") Long itemId ) {
        cartService.itemOperation(itemId,ItemOperations.REMOVE);
        return "cartView";
    }



}
