package com.Shopping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Shopping.model.Queries;

@Repository
public class QueriesDaoImpl implements QueriesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addQuery(Queries queries) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(queries);
            session.getTransaction().commit();
        }
    }
}
