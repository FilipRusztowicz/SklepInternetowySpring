package com.example.sklepinternetowyprojekt.Repository;

import com.example.sklepinternetowyprojekt.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
