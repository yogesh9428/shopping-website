package com.Shopping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Shopping.model.CustomerOrder;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction(); // Begin a transaction
            session.saveOrUpdate(customerOrder);
            session.getTransaction().commit(); // Commit the transaction
        }
    }
}


