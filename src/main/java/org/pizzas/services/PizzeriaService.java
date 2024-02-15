package org.pizzas.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pizzas.Models.User;
import org.pizzas.repositories.PizzeriaRepository;
import org.pizzas.repositories.interfaces.IPizzeriaRepository;
import org.pizzas.services.interfaces.IPizzeriaService;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PizzeriaService implements IPizzeriaService {
    private IPizzeriaRepository repo;
    @Override
    public boolean createUser(User user) {
//        if (repo.userExists(user)) return false;

        boolean response = repo.createUser(user);
        return response;
    }

    @Override
    public String getPizzas() {
        return repo.getPizzas();
    }
}