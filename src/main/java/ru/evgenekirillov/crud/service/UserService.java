package ru.evgenekirillov.crud.service;

import ru.evgenekirillov.crud.model.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User get(long id);

    void add(User user);

    User delete(long id);

    void update(User user);

}
