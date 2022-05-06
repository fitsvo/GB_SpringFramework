package ru.geekbrains.service.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.persist.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.ProductService;

@Service
public class ProductServiceImpl extends CRUDServiceImpl<Product> implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

    @Override
    public Product saveProduct(ProductDto dto) {
        return repository.save(mapToEntity(dto));
    }

    @Override
    public Product updateProduct(long id, ProductDto dto) {
        Product entity = mapToEntity(dto);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    private Product mapToEntity(ProductDto dto) {
        return new Product(dto.getName(), dto.getPrice());
    }
}
