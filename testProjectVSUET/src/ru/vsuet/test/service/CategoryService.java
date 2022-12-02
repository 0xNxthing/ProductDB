package ru.vsuet.test.service;
import ru.vsuet.test.domain.Category;
import ru.vsuet.test.repository.InMemoryCategoryRepository;
import ru.vsuet.test.repository.Repository;

import java.util.List;

public class CategoryService implements Service<Category> {

    private Repository<Category> repository = new InMemoryCategoryRepository();

    @Override
    public Category getById(Long id) {
        return repository.find(id);
    }

    public List<Category> getAll() {
        return repository.list();
    }

}
