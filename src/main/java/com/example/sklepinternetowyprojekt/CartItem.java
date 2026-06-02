package com.example.sklepinternetowyprojekt;

import com.example.sklepinternetowyprojekt.Model.Item;

import java.math.BigDecimal;

public class CartItem {
    private Item item;
    private int counter;
    private BigDecimal price;


    public CartItem(Item item) {
        this.item = item;
        this.counter = 1;
        this.price = item.getCena();
    }

    public void increaseCounter(){
        counter++;
        recalculatePrice();
    }

    public void decreaseCounter(){
        if(counter > 0){
            counter--;
            recalculatePrice();
        }
    }

    public void recalculatePrice(){
        price=item.getCena().multiply(new BigDecimal(counter));
    }

    public boolean hasZeroItems(){
        return counter==0;
    }

    public Item getItem() {
        return item;
    }

    public int getCounter() {
        return counter;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
