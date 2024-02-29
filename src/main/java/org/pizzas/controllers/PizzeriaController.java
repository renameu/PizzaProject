package org.pizzas.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pizzas.Models.User;
import org.pizzas.services.interfaces.IPizzeriaService;

@Getter
@Setter
@NoArgsConstructor
public class PizzeriaController{
    public IPizzeriaService service;

    private static volatile PizzeriaController instance;
    private PizzeriaController(IPizzeriaService service){
        this.service = service;
    }

    public static PizzeriaController getInstance(IPizzeriaService service) {
        if (instance == null) {
            synchronized (PizzeriaController.class) {
                if (instance == null) {
                    instance = new PizzeriaController(service);
                }
            }
        }
        return instance;
    }

    public boolean  createUser(User user) {
        boolean feedback = service.createUser(user);
        return feedback;
    }

    public String GetFullOrderDescription(int orderId){
        return service.GetFullOrderDescription(orderId);
    }

    public String getPizzas() {
        String menu = service.getPizzas();
        return menu;
    }

    public boolean order(int id, int pizza) {
        return service.order(id, pizza);
    }
}
