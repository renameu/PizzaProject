package org.pizzas.Models;




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
