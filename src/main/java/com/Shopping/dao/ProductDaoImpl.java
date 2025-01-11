package com.Shopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Shopping.model.Product;

@Repository(value = "productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("from Product", Product.class);
            List<Product> products = query.getResultList();
            System.out.println("----- List of Products-----");
            System.out.println(products);
            return products;
        }
    }

    @Override
    public Product getProductById(String productId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, productId);
        }
    }

    @Override
    public void deleteProduct(String productId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            if (product != null) {
                session.delete(product);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public void addProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void editProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }
}

