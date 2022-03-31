package ru.geekbrains;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("PROTOTYPE")
public class Cart extends ru.geekbrains.ProductRepository {

}
