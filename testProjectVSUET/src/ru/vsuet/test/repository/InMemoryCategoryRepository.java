package ru.vsuet.test.repository;
import ru.vsuet.test.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoryRepository implements Repository<Category> {

    private final List<Category> categories;

    public InMemoryCategoryRepository() {
        this.categories = Storage.getInstance().categories;
    }

    @Override
    public Category find(Long id) {
        return categories.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Category source) {
        categories.add(source);
    }

    @Override
    public void remove(Category target) {
        categories.removeIf(c -> target.getId().equals(c.getId()));
    }

    @Override
    public List<Category> list() {
        return new ArrayList<>(categories);
    }

}
