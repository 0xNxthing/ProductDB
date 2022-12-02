import java.util.Scanner;

public class Main {

    public static Sections sections = new Sections();
    public static Products products = new Products();

    public static void main(String[] args) {
        Example();
        Menu();
    }

    public static void Menu() {
        DBConnector connector = new DBConnector();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    *** MENU ***
                    1) Sections
                    2) Products
                    0) EXIT""");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> { //таблица отделов
                    do {
                        System.out.println("""
                                ***** SECTIONS *****
                                1) Show all sections
                                2) Add section
                                3) Remove section
                                4) Edit section
                                5) Add a product to the section
                                6) Remove a product in the section
                                7) Show all products in section
                                8) Show all sections without products
                                0) BACK""");

                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                sections.showAllSections();
                                break;
                            case 2:
                                //добавление нового отдела в массив
                                System.out.print("Enter section name: ");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                System.out.print("Enter work time: ");
                                String workTime = scanner.nextLine();
                                sections.addSection(name, workTime);
                                break;
                            case 3:
                                //удаление отдела из массива
                                if (!sections.getSections().isEmpty()) {
                                    System.out.print("Choose a section (id): ");
                                    sections.removeSection(sections.findSectionById(scanner.nextInt()));
                                } else {
                                    System.out.println("There are no sections..");
                                }
                                break;
                            case 4:
                                //изменение одного из отделов
                                if (!sections.getSections().isEmpty()) {
                                    System.out.print("Choose a section (id): ");
                                    Section updatedSection = sections.findSectionById(scanner.nextInt());
                                    System.out.println("(Not change - void)");
                                    System.out.print("Edit section name: ");
                                    scanner.nextLine();
                                    String updatedName = scanner.nextLine();
                                    System.out.print("Edit work time: ");
                                    String updatedWorkTime = scanner.nextLine();
                                    sections.updateSection(updatedSection, updatedName, updatedWorkTime);
                                } else {
                                    System.out.println("There are no sections..");
                                }
                                break;
                            case 5:
                                //добавление товара в отдел
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.findSectionById(scanner.nextInt());
                                    System.out.println("Choose a product (id)");
                                    Product product = products.findProductById(scanner.nextInt());
                                    section.addProductToSection(product);
                                } else {
                                    System.out.print("There are no sections..");
                                }
                                break;
                            case 6:
                                //удаление товара из отдела
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.findSectionById(scanner.nextInt());
                                    if (!section.getProducts().isEmpty()) {
                                        System.out.println("Choose a product (id)");
                                        Product product = products.findProductById(scanner.nextInt());
                                        section.removeProductInSection(product);
                                    } else {
                                        System.out.println("There are no products in this section..");
                                    }
                                } else {
                                    System.out.print("There are no sections..");
                                }
                                break;
                            case 7:
                                //вывод всех товаров в отделе
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.showSectionById(scanner.nextInt());
                                } else {
                                    System.out.println("There are no sections..");
                                }
                                break;
                            case 8:
                                //вывод всех отделов без товаров
                                sections.showSectionsWithoutProducts();
                                break;
                        }
                        System.out.println();
                    } while (choice != 0);
                    choice = -1;
                }
                case 2 -> { //товары
                    do {
                        System.out.println("""
                                *** PRODUCTS ***
                                1) Add a product
                                2) Remove product
                                3) Edit product
                                4) Show all products
                                0) BACK""");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                //добавление нового товара в массив
                                System.out.print("Enter product name: ");
                                scanner.nextLine();
                                String nameProduct = scanner.nextLine();
                                System.out.print("Enter product price: ");
                                int price = scanner.nextInt();
                                products.addProduct(nameProduct, price);
                                break;
                            case 2:
                                //удаление товара из массива
                                if (!products.getProducts().isEmpty()) {
                                    System.out.print("Choose a product (id): ");
                                    int id = scanner.nextInt();
                                    products.removeProduct(products.findProductById(id));
                                    sections.findProductInSection(id);
                                } else {
                                    System.out.println("There are no products.. ");
                                }
                                break;
                            case 3:
                                //изменение одного из товаров
                                if (!products.getProducts().isEmpty()) {
                                    System.out.print("Choose a product (id): ");
                                    Product updatedProduct = products.findProductById(scanner.nextInt());
                                    System.out.println("Not change - void");
                                    System.out.print("Edit product name: ");
                                    scanner.nextLine();
                                    String updatedNameProduct = scanner.nextLine();
                                    System.out.print("Edit product price: ");
                                    String updatedPrice = scanner.nextLine();
                                    products.updateProduct(updatedProduct, updatedNameProduct, updatedPrice);
                                } else {
                                    System.out.println("There are no products..");
                                }
                                break;
                            case 4:
                                //вывод всех товаров
                                products.showProducts();
                                break;
                        }
                        System.out.println();
                    } while (choice != 0);
                    choice = -1;
                }
            }
        } while (choice != 0);
    }

    public static void Example() {

        sections.addSection("Meat", "9:00 - 21:00");
        sections.addSection("Fish", "10:00 - 21:00");
        sections.addSection("Snacks", "8:00 - 22:00");

        products.addProduct("Beef", 8);
        products.addProduct("Salmon", 12);
        products.addProduct("Bread", 2);

        sections.findSectionById(1).addProductToSection(products.findProductById(1));
        sections.findSectionById(2).addProductToSection(products.findProductById(2));

    }
}