package ru.geekbrains.service.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.persist.User;
import ru.geekbrains.repository.UserRepository;
import ru.geekbrains.service.UserService;

@Service
public class UserServiceImpl extends CRUDServiceImpl<User> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }
}
