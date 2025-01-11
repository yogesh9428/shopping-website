package com.Shopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query; // Updated import for Query
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Shopping.model.Authorities;
import com.Shopping.model.Cart;
import com.Shopping.model.Customer;
import com.Shopping.model.User;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {
        System.out.println("Adding customer in DAO");
        try (Session session = sessionFactory.openSession()) {
            // customer - has users, shippingAddress
            customer.getUsers().setEnabled(true);

            Authorities authorities = new Authorities();
            authorities.setAuthorities("ROLE_USER");
            authorities.setEmailId(customer.getUsers().getEmailId());

            Cart cart = new Cart();
            customer.setCart(cart); // Set the cart to the customer
            cart.setCustomer(customer); // Set the customer to the cart

            session.beginTransaction(); // Start a transaction
            session.save(customer);
            session.save(authorities);
            session.getTransaction().commit(); // Commit the transaction
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        }
    }

    @Override
    public Customer getCustomerByemailId(String emailId) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where emailId = :emailId", User.class);
            query.setParameter("emailId", emailId);
            User users = query.uniqueResult();
            return users != null ? users.getCustomer() : null;
        }
    }
}
