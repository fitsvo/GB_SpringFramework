package ru.geekbrains.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.persist.User;
import ru.geekbrains.service.CRUDService;

@RestController
@RequestMapping("/v1/user")
public class UserController extends CrudController<User>{

    public UserController(CRUDService<User> crudService) {
        super(crudService);
    }
}
