package ru.geekbrains.service.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.dto.CreateOrderDto;
import ru.geekbrains.dto.OrderItemDto;
import ru.geekbrains.persist.Order;
import ru.geekbrains.persist.OrderItem;
import ru.geekbrains.persist.Product;
import ru.geekbrains.repository.OrderItemRepository;
import ru.geekbrains.repository.OrderRepository;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.repository.UserRepository;
import ru.geekbrains.service.OrderService;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends CRUDServiceImpl<Order> implements OrderService {
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        super(orderRepository);
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(CreateOrderDto createOrderDto) {
        Order order = new Order();
        order.setUser(userRepository.getById(createOrderDto.getUserId()));
        order.setOrderItemList(
                createOrderDto.getItems()
                        .stream()
                        .map(this::mapToEntity)
                        .map(orderItemRepository::save)
                        .collect(Collectors.toList())
        );
        return repository.save(order);
    }

    private OrderItem mapToEntity(OrderItemDto orderItemDto) {
        OrderItem item = new OrderItem();
        Product product = productRepository.getById(orderItemDto.getProductId());
        item.setProduct(product);
        item.setProductPrice(product.getPrice());
        item.setAmount(orderItemDto.getAmount());
        return item;
    }
}
