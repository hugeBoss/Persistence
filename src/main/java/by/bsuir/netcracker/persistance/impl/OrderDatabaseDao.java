package by.bsuir.netcracker.persistance.impl;

import by.bsuir.netcracker.persistance.dao.OrderDao;
import by.bsuir.netcracker.persistance.models.OrderEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.sql.SQLQueryReturnProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class OrderDatabaseDao implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(OrderEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete OrderEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, OrderEntity author) throws SQLException {

    }

    public List<OrderEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<OrderEntity> orders = null;
        Query query = session.createQuery("FROM OrderEntity");
        orders = query.getResultList();
        session.close();

        return orders;
    }

    public OrderEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        OrderEntity order = null;
        Query query = session.createQuery("FROM OrderEntity WHERE id = :id");
        query.setParameter("id", id);
        order = (OrderEntity) query.getSingleResult();
        session.close();

        return order;
    }
}
