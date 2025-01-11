package com.Shopping.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Shopping.model.Cart;
import com.Shopping.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession(); // Use current session
        session.saveOrUpdate(cartItem);
    }

    @Override
    public void removeCartItem(String cartItemId) {
        Session session = sessionFactory.getCurrentSession(); // Use current session
        CartItem cartItem = session.get(CartItem.class, cartItemId);

        if (cartItem != null) {
            session.delete(cartItem);
            Cart cart = cartItem.getCart();
            List<CartItem> cartItems = cart.getCartItem();
            cartItems.remove(cartItem); // Remove from cart's list
        }
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItem();
        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem.getCartItemId());
        }
    }
}

