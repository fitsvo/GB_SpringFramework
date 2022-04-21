package ru.geekbrains.persist;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(
        name = "line_items",
        indexes = {
                @Index(name = "ux_product_customer", columnList = "product_id, customer_id, color, size", unique = true)
        }
)
public class LineItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Long qty;

    @Column
    private String color;

    @Column
    private String size;

    public LineItem() {
    }

    public LineItem(Product product, Buyer buyer, BigDecimal price, Long qty, String color, String size) {
        this.product = product;
        this.buyer = buyer;
        this.price = price;
        this.qty = qty;
        this.color = color;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
