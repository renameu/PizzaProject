package org.pizzas;

import org.pizzas.controllers.PizzeriaController;
import org.pizzas.data.PostgresDB;
import org.pizzas.data.interfaces.IDB;
import org.pizzas.repositories.PizzeriaRepository;
import org.pizzas.repositories.interfaces.IPizzeriaRepository;
import org.pizzas.services.PizzeriaService;
import org.pizzas.services.interfaces.IPizzeriaService;

public class Main {
    public static void main(String[] args) {
        IDB db = PostgresDB.getInstance();
        IPizzeriaRepository repo = PizzeriaRepository.getInstance(db);
        IPizzeriaService service = PizzeriaService.getInstance(repo);
        PizzeriaController controller = PizzeriaController.getInstance(service);
        MyApplication app = MyApplication.getInstance(controller);
        app.start();
    }
}