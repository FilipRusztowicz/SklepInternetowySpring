package com.example.sklepinternetowyprojekt;

import com.example.sklepinternetowyprojekt.Model.Item;
import com.example.sklepinternetowyprojekt.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Autowired
    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("Lechia Gdańsk",new BigDecimal("12.5"),"https://sklep.lechia.pl/wp-content/uploads/2025/07/pasiak-adidas.jpg"),
                new Item("Lech poznań",new BigDecimal("12.5"),"https://thumblr.uniid.it/product/256721/4eb5092dccbf.jpg?width=3840&format=webp&q=75"),
                new Item("Shaktar Doniecks",new BigDecimal("12.5"),"https://thumblr.uniid.it/product/151128/a64098b563f7.jpg?width=3840&format=webp&q=75")
        ));
    }

}
