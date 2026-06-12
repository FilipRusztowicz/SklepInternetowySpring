package com.example.sklepinternetowyprojekt;

import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Repository.ItemRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    public List<CartItem> cartItems = new ArrayList<>();
    int counter;
    BigDecimal sum= new BigDecimal(0.0);
    ItemRepository itemRepository;

//    public Cart(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//        List<Item> items = itemRepository.findAll();
//        for(Item item : items){
//            this.addItem(item);
//            this.addItem(item);;
//        }
//    }

    private Optional<CartItem> getCartItemByItem(Item item){
        return cartItems.stream().filter(cartItem -> cartItem.isEquals(item)).findFirst();
    }

    public void addItem(Item item) {
        getCartItemByItem(item).ifPresentOrElse(
                CartItem::increaseCounter,
                () -> {
                    CartItem newCartItem = new CartItem(item);
                    cartItems.add(newCartItem);
                }
        );
        recalculatePriceAndCounter();
    }

    public void decreaseItem(Item item) {
        Optional<CartItem> oCartItem = getCartItemByItem(item);
        if (oCartItem.isPresent()) {
            CartItem cartItem = oCartItem.get();
            cartItem.decreaseCounter();
            if (cartItem.hasZeroItems()) {
                removeAllItems(item);
            }
            recalculatePriceAndCounter();
        }
    }

    public void removeAllItems(Item item) {
        cartItems.removeIf(i->i.isEquals(item));

        recalculatePriceAndCounter();

    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    private void recalculatePriceAndCounter() {
        this.counter = cartItems.stream()
                .mapToInt(CartItem::getCounter)
                .sum();
        this.sum = cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
