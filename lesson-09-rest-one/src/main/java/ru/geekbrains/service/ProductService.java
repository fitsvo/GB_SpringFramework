package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.dto.ProductDto;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findProductsByFilter(String titleFilter, String priceFilter, Integer page, Integer size, String sortField);

    Optional<ProductDto> findById(long id);

    ProductDto save (ProductDto user);

    void deleteById(long id);
}
