package ru.vsuet.test.domain;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private Long id;
    private String name;
    private String workTime;
    private List<Item> items;

    public Category(Long id, String name, String workTime) {
        this.id = id;
        this.name = name;
        this.workTime = workTime;
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkTime() { return workTime; }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "ID - " + id + "\nName Section - " + name + "\nWork Time - " + workTime + "\nProducts: \n" + items + "\n";
    }

}
