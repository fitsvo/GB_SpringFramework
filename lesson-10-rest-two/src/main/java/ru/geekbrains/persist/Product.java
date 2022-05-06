package ru.geekbrains.persist;

public class Product extends Entity {
    private Long id;
    private String title;

    private long price;

    public Product() {
    }

    public Product(String title, long price) {
        this.title = title;
        this.price = price;
    }

    public Product(long id, String title, long price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {return price; }

    public void setPrice(long price) { this.price = price;}


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost='" + price + '\'' +
                '}';
    }
}
