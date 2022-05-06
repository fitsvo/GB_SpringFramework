package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.User;

import java.util.stream.Stream;

@Repository
public class UserRepository extends AbstractRepository<User> {
    public UserRepository() {
        initiateData();
    }

    @Override
    protected String getEntityName() {
        return "User";
    }

    private void initiateData() {
        Stream.of(
                        new User( "User 1"),
                        new User( "User 2"),
                        new User( "User 3"),
                        new User( "User 4"),
                        new User( "User 5"))
                .forEach(this::save);
    }
}
