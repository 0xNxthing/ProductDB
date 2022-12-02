package ru.vsuet.test.repository;
import ru.vsuet.test.domain.Category;
import ru.vsuet.test.domain.Item;

import java.util.ArrayList;
import java.util.List;

class Storage {

    private static Storage instance;

    public static Storage getInstance() {

        if (instance == null) {
            instance = new Storage();
        }
        return instance;

    }

    List<Category> categories;

    private Storage() {
        this.categories = new ArrayList<>();
        init();
    }

    private void init() {

        Category category1 = new Category(1L, "Beef Section", "10:00 - 20:00");
        Item item1 = new Item(1L, "Beef", 10);
        category1.addItem(item1);

        Category category2 = new Category(2L, "Fish Section", "10:00 - 21:00");

        categories.add(category1);
        categories.add(category2);

    }

}
