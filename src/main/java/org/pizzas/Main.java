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
        IDB db = new PostgresDB();
        IPizzeriaRepository repo = new PizzeriaRepository(db);
        IPizzeriaService service = new PizzeriaService(repo);
        PizzeriaController controller = new PizzeriaController(service);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}