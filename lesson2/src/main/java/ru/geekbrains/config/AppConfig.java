package ru.geekbrains.config;

import ru.geekbrains.Cart;
import ru.geekbrains.Product;
import ru.geekbrains.ProductRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

    @Bean("pr")
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Product product(){
        String[] name = {
                "Огурцы","Сыр", "Молоко", "Йогурт","Хлеб","Конфеты","Чай", "Курица", "Лук", "Тунец","Кефир"};
        Integer[] cost = {50, 100, 54, 23, 28, 12, 60, 45, 120};
        return new Product(name[(int) (Math.random() * name.length)],
                cost[(int) (Math.random() * cost.length)]);
    }

    @Bean("cart")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Cart cart(){
        return new Cart();
    }


}
