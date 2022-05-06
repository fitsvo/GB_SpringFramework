package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.Product;

import java.util.stream.Stream;


@Repository
public class ProductRepository extends AbstractRepository<Product> {
    public ProductRepository() {
        initialData();
    }


    @Override
    protected String getEntityName() {
        return "Product";
    }

    private void initialData() {
        Stream.of(
                new Product("Milk", 60L),
                new Product( "Cheese", 120L),
                new Product( "Potato", 30L),
                new Product( "Bread", 25L),
                new Product( "Tea", 55L)
        ).forEach(this::save);
    }
}
