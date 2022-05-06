package ru.geekbrains.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.Order;

import java.util.List;

@Repository
public class OrderRepository extends AbstractRepository<Order> {

    @Autowired
    public OrderRepository(OrderItemRepository orderItemRepository,
                           UserRepository userRepository) {
        super();
        initialData(orderItemRepository, userRepository);
    }

    @Override
    protected String getEntityName() {
        return "Order";
    }

    private void initialData(OrderItemRepository orderItemRepository, UserRepository userRepository) {
        Order order = new Order();
        order.setOrderItemList(
                List.of(orderItemRepository.getById(1L),
                        orderItemRepository.getById(2L))
        );
        order.setUser(userRepository.getById(1L));
        save(order);
    }
}
