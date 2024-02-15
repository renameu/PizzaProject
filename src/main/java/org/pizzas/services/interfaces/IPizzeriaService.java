package org.pizzas.services.interfaces;

import org.pizzas.Models.User;

public interface IPizzeriaService {
    boolean createUser(User user);

    String getPizzas();
}

