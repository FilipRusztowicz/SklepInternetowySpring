package com.example.sklepinternetowyprojekt.Controler;

import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ItemRepository itemRepository;
    @Autowired
    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    private String adminPage(){
        return "adminview/addItem";
    }

    @PostMapping
    private String addItem(Item item){
        itemRepository.save(item);
        return "redirect:/";
    }
}
