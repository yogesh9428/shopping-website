package com.Shopping.dao;

import com.Shopping.model.Cart;
import com.Shopping.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);

}

