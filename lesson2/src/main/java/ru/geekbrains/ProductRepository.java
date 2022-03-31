package ru.geekbrains;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ProductRepository {
    private final ArrayList<Product> ProductRepository;

    public ProductRepository(){
        this.ProductRepository = new ArrayList<>();
    }

    public int size(){
       return ProductRepository.size();
    }

    public Product get(int id){
        return ProductRepository.get(id);
    }

    public void all(){
        for (Product product : ProductRepository) {
            System.out.printf("%s. %s %s;", product.getId(),
                    product.getTitle(),
                    product.getCost());
            System.out.println();
        }
    }

    public void add(Product product) {
        ProductRepository.add(product);
    }

    protected void remove(int id) {
        ProductRepository.remove(id);
    }
}
