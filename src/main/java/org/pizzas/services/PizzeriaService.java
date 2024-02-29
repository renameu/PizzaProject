package org.pizzas.services;


import org.pizzas.Models.User;

import org.pizzas.repositories.interfaces.IPizzeriaRepository;
import org.pizzas.services.interfaces.IPizzeriaService;

public class PizzeriaService implements IPizzeriaService {
    private IPizzeriaRepository repo;

    private static volatile PizzeriaService instance;
    private PizzeriaService(IPizzeriaRepository repo){
        this.repo = repo;
    }

    public static PizzeriaService getInstance(IPizzeriaRepository repo) {
        if (instance == null) {
            synchronized (PizzeriaService.class) {
                if (instance == null) {
                    instance = new PizzeriaService(repo);
                }
            }
        }
        return instance;
    }

    @Override
    public boolean createUser(User user) {
        boolean response = repo.createUser(user);
        return response;
    }

    @Override
    public String GetFullOrderDescription(int orderId){
        return repo.GetFullOrderDescription(orderId);
    }

    @Override
    public boolean order(int id, int pizza){
        return repo.order(id, pizza);
    }
    @Override
    public String getPizzas() {
        return repo.getPizzas();
    }
}