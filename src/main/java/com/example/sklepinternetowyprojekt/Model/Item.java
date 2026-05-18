package com.example.sklepinternetowyprojekt.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    private String nazwa;
    private BigDecimal cena;
    private String imgURL;
}
