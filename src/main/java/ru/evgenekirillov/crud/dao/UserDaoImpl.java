package ru.evgenekirillov.crud.dao;

import org.springframework.stereotype.Repository;
import ru.evgenekirillov.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User delete(long id) {
        User user = get(id);
        if (user != null) {
            entityManager.remove(user);
            entityManager.flush();
        }
        return user;
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
}
