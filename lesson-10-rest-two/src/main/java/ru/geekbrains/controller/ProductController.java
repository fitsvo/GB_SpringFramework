package ru.geekbrains.controller;

import ru.geekbrains.persist.Product;
import ru.geekbrains.dto.ProductDto;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.service.ProductService;


@RestController
@RequestMapping("/v1/product")
public class ProductController extends CrudController<Product> {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto dto) {
        return productService.saveProduct(dto);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable long id, @RequestBody ProductDto dto) {
        return productService.updateProduct(id, dto);
    }
}
