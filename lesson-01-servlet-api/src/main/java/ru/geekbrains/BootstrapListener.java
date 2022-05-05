package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        Random rand = new Random();
        String[] products = {"Melon", "Lime", "Pumpkin", "Peach", "Beans", "Cucumber", "Tomato", "Lemon", "Potato", "Carrot"};

        for (int i = 0; i < 10; i++) {
            long price = rand.nextInt(50 * (i + 1));
            Product product = new Product(products[i], price);
            product.setId(i + 1);
            productRepository.insert(product);
        }

        sce.getServletContext().setAttribute("productRepository", productRepository);
    }
}
