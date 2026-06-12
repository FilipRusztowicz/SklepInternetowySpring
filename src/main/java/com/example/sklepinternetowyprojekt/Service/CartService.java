package com.example.sklepinternetowyprojekt.Service;

import com.example.sklepinternetowyprojekt.Cart;
import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final ItemRepository itemRepository;
    private final Cart cart;

    @Autowired
    public CartService(ItemRepository itemRepository, Cart cart) {
        this.cart = cart;
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
    public void addItemToCart(Long itemId){
        Optional<Item> oItem = itemRepository.findById(itemId);
        oItem.ifPresent(cart::addItem);
    }

    public void decreaseItem(Long itemId){
        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()) {
            Item item = oItem.get();
            cart.decreaseItem(item);
        }
    }

    public void removeItem(Long itemId){
        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()) {
            Item item = oItem.get();
            cart.removeAllItems(item);
        }
    }
}
