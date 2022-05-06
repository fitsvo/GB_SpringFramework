package ru.geekbrains.dto;

public class OrderItemDto {
    private long productId;
    private int amount;


    public OrderItemDto() {
    }

    public OrderItemDto(long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
