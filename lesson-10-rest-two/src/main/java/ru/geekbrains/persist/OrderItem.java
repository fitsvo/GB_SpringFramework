package ru.geekbrains.persist;

public class OrderItem extends Entity {
    private Order order;
    private Product product;
    private int amount;
    private long productPrice;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, int amount, long productPrice) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.productPrice = productPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }
}
