package org.pizzas.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    private int id;
    private String type;
    private int size;
    private String description;
    private double price;

    @Override
    public String toString(){
        return id + " " + type + " " + size + " " + description + " " + price;
    }


}
