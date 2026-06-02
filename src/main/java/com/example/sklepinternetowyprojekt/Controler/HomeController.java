package com.example.sklepinternetowyprojekt.Controler;
import com.example.sklepinternetowyprojekt.Cart;
import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//alt+ctrl+o  ->usuwa nieużywane importy

@Controller
public class HomeController {

    private final ItemRepository itemRepository;
    private final Cart cart;

    @Autowired
    public HomeController(ItemRepository itemRepository, Cart cart) {
        this.cart = cart;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    //@ResponseBody //-> tego sie używa by nasłuchiwać tego, co funkcja pod nią zwróci
    public String home(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);

        return "home";

    }
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId) {
        Optional<Item> oItem = itemRepository.findById(itemId);
        oItem.ifPresent(cart::addItem);

        return "redirect:/";
    }
}
