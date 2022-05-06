package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.OrderItem;
import ru.geekbrains.persist.Product;


@Repository
public class OrderItemRepository extends AbstractRepository<OrderItem> {

    public OrderItemRepository(ProductRepository productRepository) {
        initialData(productRepository);
    }

    @Override
    protected String getEntityName() {
        return "Order";
    }

    private void initialData(ProductRepository productRepository) {
        OrderItem orderItem = new OrderItem();
        Product product = productRepository.getById(1L);
        orderItem.setAmount(2);
        orderItem.setProduct(product);
        orderItem.setProductPrice(product.getPrice());
        save(orderItem);

        OrderItem orderItem2 = new OrderItem();
        Product product2 = productRepository.getById(2L);
        orderItem2.setAmount(3);
        orderItem2.setProductPrice(product2.getPrice());
        orderItem2.setProduct(product2);
        save(orderItem2);
    }

}
