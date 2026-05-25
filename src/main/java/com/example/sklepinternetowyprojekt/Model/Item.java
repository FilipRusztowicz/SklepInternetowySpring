package com.example.sklepinternetowyprojekt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue //każdy nowy item to sie zinkrementuje id samo
    private Long id;
    private String nazwa;
    private BigDecimal cena;
    private String imgURL;
    public Item(String nazwa, BigDecimal cena, String imgURL) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.imgURL = imgURL;
    }


}
