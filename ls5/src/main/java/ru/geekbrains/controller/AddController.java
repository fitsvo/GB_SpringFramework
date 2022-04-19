package ru.geekbrains.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.entity.Product;
import ru.geekbrains.model.dao.ProductDao;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/")
public class AddController {
    ProductDao productRepository = new ProductDao();

    @GetMapping("/product")
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product")
    public String create(@ModelAttribute Product product, Model model) {
        productRepository.save(product);
        model.addAttribute("product", product);
        return "redirect:/product";
    }
}
