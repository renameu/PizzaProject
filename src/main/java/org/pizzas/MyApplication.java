package org.pizzas;

import org.pizzas.Models.User;
import org.pizzas.controllers.PizzeriaController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final PizzeriaController controller;
    Scanner scanner = new Scanner(System.in);
    public MyApplication(PizzeriaController controller) {
        this.controller = controller;
    }

    public void start() {
        boolean exit = false;
        System.out.println("Welcome to Pizzeria 'Gigabyte' ");
        User user;
        int age, id, cash, size, price;
        String email, name, description, type;
        while (!exit) {
            showMenu();

            try {
                System.out.print("Select option: ");
                String op = scanner.nextLine();
                int option = Integer.parseInt(op);
                System.out.println();
                switch (option) {
                    case 1:
                        System.out.print("Please enter name: ");
                        name = scanner.nextLine();
                        System.out.print("Please enter your age: ");
                        age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter email: ");
                        email = scanner.nextLine();
                        System.out.print("Please enter your cash: ");
                        cash = Integer.parseInt(scanner.nextLine());
                        user = new User(0 , name, age, email, cash);
                        boolean feedback = controller.createUser(user);

                        System.out.println(feedback ? name +  " was created successfully!" : "Errore :(");

                        break;
                    case 2:
                        String menu = controller.getPizzas();
                        System.out.println(menu);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("There must be option between (0-9).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e.getMessage());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Create user");
        System.out.println("2. Menu");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("0. Exit");

    }
}
