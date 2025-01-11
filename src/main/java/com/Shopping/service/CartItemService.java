package com.Shopping.service;

import com.Shopping.model.Cart;
import com.Shopping.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
