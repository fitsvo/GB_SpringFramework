package ru.geekbrains.dto;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private BigDecimal price;

    public ProductDto() {
    }

    public ProductDto(long id, String title, BigDecimal price) {
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

    public BigDecimal getPrice() {return price; }

    public void setPrice(BigDecimal price) { this.price = price;}
}
