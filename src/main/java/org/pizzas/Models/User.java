package org.pizzas.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private int cash;
    private String  toGender(boolean gender){
        return (gender ? "male" : "female");
    }
    @Override
    public String toString(){
        return id + " " + name + " " + " " + age + " " + email + " " + cash;
    }
}
