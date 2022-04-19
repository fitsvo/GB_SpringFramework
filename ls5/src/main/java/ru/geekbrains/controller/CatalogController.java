package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.model.entity.Product;
import ru.geekbrains.model.dao.ProductDao;

import java.util.List;

@Controller
@RequestMapping("/")
public class CatalogController {
    ProductDao productRepository = new ProductDao();

    @GetMapping("/catalog")
    public String index(Model model){
        List<Product> productList = productRepository.getAll();
        model.addAttribute("productList", productList);
        return "catalog";
    }
}
