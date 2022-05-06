package ru.geekbrains.dto;


import java.util.List;

public class CreateOrderDto {
    private long userId;
    private List<OrderItemDto> items;

    public CreateOrderDto(long userId, List<OrderItemDto> items) {
        this.userId = userId;
        this.items = items;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
