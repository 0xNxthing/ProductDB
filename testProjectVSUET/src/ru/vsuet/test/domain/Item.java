package ru.vsuet.test.domain;

public class Item {

    private Long id;
    private String name;
    private int price;

    public Item(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() { return price; }

    @Override
    public String toString() {
        return "Product ID - " + id + "\nProduct - " + name + "\nPrice - " + price;
    }

}
