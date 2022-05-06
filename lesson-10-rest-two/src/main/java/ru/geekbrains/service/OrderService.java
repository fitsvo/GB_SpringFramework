package ru.geekbrains.service;

import ru.geekbrains.dto.CreateOrderDto;
import ru.geekbrains.persist.Order;

public interface OrderService extends CRUDService<Order> {
    Order createOrder(CreateOrderDto createOrderDto);

}
