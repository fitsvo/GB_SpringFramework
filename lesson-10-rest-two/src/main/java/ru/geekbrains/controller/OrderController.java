package ru.geekbrains.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.dto.CreateOrderDto;
import ru.geekbrains.persist.Order;
import ru.geekbrains.service.OrderService;

@RestController
@RequestMapping("/v1/order")
public class OrderController extends CrudController<Order> {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderDto order) {
        return orderService.createOrder(order);
    }
}
