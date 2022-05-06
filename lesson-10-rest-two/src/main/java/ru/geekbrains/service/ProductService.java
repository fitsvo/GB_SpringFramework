package ru.geekbrains.service;

import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.persist.Product;

public interface ProductService extends CRUDService<Product> {

    Product saveProduct(ProductDto dto);

    Product updateProduct(long id, ProductDto dto);

}
