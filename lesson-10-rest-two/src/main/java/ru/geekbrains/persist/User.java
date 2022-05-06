package ru.geekbrains.persist;

public class User extends Entity {
    private String name;

    public User(long id, String name) {
        super(id);
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
