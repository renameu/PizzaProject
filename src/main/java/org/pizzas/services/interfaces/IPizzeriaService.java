package org.pizzas.services.interfaces;

import org.pizzas.Models.User;

public interface IPizzeriaService {
    boolean createUser(User user);

    String GetFullOrderDescription(int orderId);

    String getPizzas();

    boolean order(int id, int pizza);
}

