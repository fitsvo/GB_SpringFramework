package ru.geekbrains.dto;


public class ProductDto {

    private Long id;

    private String name;

    private long price;

    public ProductDto() {
    }

    public ProductDto(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {return price; }

    public void setPrice(long price) { this.price = price;}
}
