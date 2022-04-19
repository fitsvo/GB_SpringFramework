package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.persist.Product;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findUsersByFilter(String titleFilter, String priceFilter, Integer page, Integer size);

    Optional<ProductDto> findById(long id);

    ProductDto save (ProductDto product);

    void deleteById(long id);
}
