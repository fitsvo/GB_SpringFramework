package ru.geekbrains.service.impl;


import ru.geekbrains.persist.Entity;
import ru.geekbrains.repository.AbstractRepository;
import ru.geekbrains.service.CRUDService;

import java.util.List;

public abstract class CRUDServiceImpl<T extends Entity> implements CRUDService<T> {
    protected AbstractRepository<T> repository;
    public CRUDServiceImpl(AbstractRepository<T> repository){
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
