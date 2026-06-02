package com.example.sklepinternetowyprojekt;

import com.example.sklepinternetowyprojekt.Model.Item;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    List<CartItem> cartItems = new ArrayList<>();
    int counter;
    BigDecimal sum= new BigDecimal(0.0);

    public void addItem(Item item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getId().equals(item.getId())) {
                cartItem.increaseCounter();
                recalculatePriceAndCounter();
                return;
            }
        }
        CartItem newCartItem = new CartItem(item);
        cartItems.add(newCartItem);
        recalculatePriceAndCounter();
    }

    public void removeItem(Item item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getId().equals(item.getId())) {
                cartItem.decreaseCounter();
                if (cartItem.hasZeroItems()) {
                    cartItems.remove(cartItem);
                }
                recalculatePriceAndCounter();
                return;
            }
        }
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
        sum = BigDecimal.ZERO;
        counter = 0;
        for (CartItem cartItem : cartItems) {
            cartItem.recalculatePrice();
            sum = sum.add(cartItem.getPrice());
            counter += cartItem.getCounter();
        }
    }


}
