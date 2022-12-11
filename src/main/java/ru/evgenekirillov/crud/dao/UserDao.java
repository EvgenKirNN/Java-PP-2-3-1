package ru.evgenekirillov.crud.dao;

import ru.evgenekirillov.crud.model.User;

import java.util.List;

public interface UserDao {

    List<User> list();

    User get(long id);

    void add(User user);

    User delete(long id);

    void update(User user);
}
