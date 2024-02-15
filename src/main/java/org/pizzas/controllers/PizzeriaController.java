package org.pizzas.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pizzas.Models.User;
import org.pizzas.services.interfaces.IPizzeriaService;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzeriaController{
    public IPizzeriaService service;
    public boolean  createUser(User user) {
        boolean feedback = service.createUser(user);
        return feedback;
    }

    public String getPizzas() {
        String menu = service.getPizzas();
        return menu;
    }
}
