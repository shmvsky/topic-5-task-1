package ru.shmvsky.usinghibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.shmvsky.usinghibernate.entity.Todo;

import java.util.List;

@Repository
public class TodoRepository {

    private final SessionFactory sessionFactory;

    public TodoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Todo todo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(todo);
        session.getTransaction().commit();
        session.close();
    }

    public Todo findById(Integer id) {
        Session session = sessionFactory.openSession();
        Todo todo = session.get(Todo.class, id);
        session.close();
        return todo;
    }

    public List<Todo> findAll() {
        Session session = sessionFactory.openSession();
        List<Todo> todos = session.createQuery("from Todo", Todo.class).list();
        session.close();
        return todos;
    }

    public List<Todo> findAll(int page, int size) {
        Session session = sessionFactory.openSession();
        List<Todo> todos = session.createQuery("from Todo", Todo.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
        session.close();
        return todos;
    }

    public void update(Todo todo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(todo);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Todo todo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(todo);
        session.getTransaction().commit();
        session.close();
    }

}
