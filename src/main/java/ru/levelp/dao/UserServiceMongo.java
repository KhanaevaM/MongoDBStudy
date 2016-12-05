package ru.levelp.dao;

import ru.levelp.User;

import java.util.List;

public class UserServiceMongo extends BaseMongoService<User> implements UserDAO {

    public UserServiceMongo() {
        super(User.class);
    }

    public List<User> getAll() {
        return request().createQuery(User.class)
                .asList();
    }

    public User getByEmail(String email) {
        return request().createQuery(User.class)
                .field(UserDAO.FIELD_EMAIL).equal(email)
                .get();
    }
}

