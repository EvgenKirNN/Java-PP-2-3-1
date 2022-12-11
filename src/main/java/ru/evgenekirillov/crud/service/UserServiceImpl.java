package ru.evgenekirillov.crud.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgenekirillov.crud.dao.UserDao;
import ru.evgenekirillov.crud.model.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User delete(long id) {
        User user = null;

        try {
            user = userDao.delete(id);
        }
        catch (NullPointerException ignored) {
        }

        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}