package com.example.sklepinternetowyprojekt.Controler;
import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//alt+ctrl+o  ->usuwa nieużywane importy

@Controller
public class HomeController {

    private final CartService cartService;

    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    //@ResponseBody //-> tego sie używa by nasłuchiwać tego, co funkcja pod nią zwróci
    public String home(Model model){
        List<Item> items = cartService.getAllItems();
        model.addAttribute("items",items);

        return "home";

    }
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {
        cartService.addItemToCart(itemId);
        model.addAttribute("items",cartService.getAllItems());

        return "home";
    }
}
