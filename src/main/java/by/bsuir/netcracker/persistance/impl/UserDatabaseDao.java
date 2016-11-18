package by.bsuir.netcracker.persistance.impl;

import by.bsuir.netcracker.persistance.dao.UserDao;
import by.bsuir.netcracker.persistance.models.PhoneEntity;
import by.bsuir.netcracker.persistance.models.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class UserDatabaseDao implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(UserEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete UserEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void update(int id, UserEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("update UserEntity set name = :name, surname = :surname, adress = :adress, login = :login, password = :password WHERE id = :id");
        query.setParameter("name", elem.getName());
        query.setParameter("surname", elem.getSurname());
        query.setParameter("adress", elem.getAdress());
        query.setParameter("login", elem.getLogin());
        query.setParameter("password", elem.getPassword());
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public List<UserEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<UserEntity> users = null;

        Query query = session.createQuery("FROM UserEntity");
        users = query.getResultList();

        session.close();

        return users;
    }

    public UserEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        UserEntity user = null;
        Query query = session.createQuery("FROM UserEntity WHERE id = :id");
        query.setParameter("id", id);
        user = (UserEntity) query.getSingleResult();
        session.close();

        return user;
    }
}
