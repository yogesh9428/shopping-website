package com.Shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.dao.CartDao;
import com.Shopping.model.Cart;

@Service
public class CartServiceImpl implements CartService {

    private final CartDao cartDao;

    // Constructor injection
    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public Cart getCartByCartId(String CartId) {
        return cartDao.getCartByCartId(CartId);
    }
}
