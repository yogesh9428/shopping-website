package com.Shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.dao.CartItemDao;
import com.Shopping.model.Cart;
import com.Shopping.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	public CartItemDao getCartItemDao() {
		return cartItemDao;
	}

	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	public void removeCartItem(String CartItemId) {
		cartItemDao.removeCartItem(CartItemId);
	}

	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}

}
