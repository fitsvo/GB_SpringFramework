package ru.geekbrains.persist;


import java.util.List;

public class Order extends Entity {
    private User user;
    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(User user, List<OrderItem> orderItemList) {
        this.user = user;
        this.orderItemList = orderItemList;
    }

    public Order(Long id, User user, List<OrderItem> orderItemList) {
        super(id);
        this.user = user;
        this.orderItemList = orderItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public long getTotalPrice() {
        return orderItemList.stream()
                .map(orderItem -> orderItem.getProductPrice() * orderItem.getAmount())
                .reduce(0L, Long::sum);
    }
}
