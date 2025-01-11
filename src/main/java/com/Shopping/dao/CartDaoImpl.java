package com.Shopping.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Shopping.model.Cart;
import com.Shopping.service.CustomerOrderService;
import com.Shopping.dao.CartNotFoundException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    @Lazy
    private CustomerOrderService customerOrderService;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cart getCartByCartId(String cartId) {
        Session session = sessionFactory.getCurrentSession(); // Use current session
        Cart cart = session.get(Cart.class, cartId);
        return cart; // Avoid null checks; if null, it's handled elsewhere
    }

    @Override
    public Cart validate(String cartId) {
        Cart cart = Optional.ofNullable(getCartByCartId(cartId))
                            .orElseThrow(() -> new CartNotFoundException("Cart with ID " + cartId + " not found"));

        if (cart.getCartItem().isEmpty()) {
            throw new CartNotFoundException("Cart " + cartId + " has no items.");
        }

        update(cart);
        return cart;
    }

    @Override
    public void update(Cart cart) {
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cart.getCartId());
        cart.setTotalPrice(grandTotal);

        // Using current session for automatic transaction management
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }
}
