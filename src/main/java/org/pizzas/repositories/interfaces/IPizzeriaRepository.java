package org.pizzas.repositories.interfaces;

import org.pizzas.Models.User;

public interface IPizzeriaRepository {
    boolean createUser(User user);

    String getPizzas();



    String GetFullOrderDescription(int orderId);

    boolean order(int id, int pizza);
}
