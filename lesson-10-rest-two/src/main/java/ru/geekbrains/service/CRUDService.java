package ru.geekbrains.service;

import ru.geekbrains.persist.Entity;

import java.util.List;

public interface CRUDService<T extends Entity> {
    List<T> getAll();

    T getById(long id);

    void deleteById(long id);
}
