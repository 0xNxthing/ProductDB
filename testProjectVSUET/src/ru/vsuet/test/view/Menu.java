package ru.vsuet.test.view;
import ru.vsuet.test.domain.Category;
import ru.vsuet.test.service.Service;
import ru.vsuet.test.service.CategoryService;
import java.util.List;

import java.util.Scanner;

public class Menu {

    private final Scanner keyboard = new Scanner(System.in);

    private final Service<Category> service = new CategoryService();

    public void draw() {
        while (true) {
            drawMenu();
        }
    }

    private void drawMenu() {
        System.out.println("***** Menu *****");
        System.out.println("1 - Sections list");
        System.out.println("2 - Section by ID");
        System.out.println("0 - Exit");
        System.out.println("*****************");

        int command  = keyboard.nextInt();
        executeCommand(command);
    }

    private void executeCommand(int command) {
        switch (command) {
            case 1 -> drawObjectsList();
            case 2 -> drawSingleObject();
            case 0 -> System.exit(0);
            default -> throw new IllegalArgumentException("Command not found");
        }
    }

    private void drawSingleObject() {
        System.out.println("Enter section ID: ");
        long id = keyboard.nextLong();
        Category category = service.getById(id);
        System.out.println(category);
    }

    private void drawObjectsList() {
        System.out.println("Sections list: ");
        List<Category> categories = service.getAll();
        categories.forEach(System.out::println);
    }

}
