package com.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Shopping.model.Cart;
import com.Shopping.model.CartItem;
import com.Shopping.model.Customer;
import com.Shopping.model.Product;
import com.Shopping.service.CartItemService;
import com.Shopping.service.CartService;
import com.Shopping.service.CustomerService;
import com.Shopping.service.ProductService;

@Controller
public class CartItemController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/cart/add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(@PathVariable(value = "productId") String productId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailId = user.getUsername();
        Customer customer = customerService.getCustomerByemailId(emailId);
        System.out.println("Customer : " + customer.getUsers().getEmailId());
        Cart cart = customer.getCart();
        System.out.println(cart);
        List<CartItem> cartItems = cart.getCartItem();
        Product product = productService.getProductById(productId);
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            if (product.getProductId().equals(cartItem.getProduct().getProductId())) {
                cartItem.setQuality(cartItem.getQuality() + 1);
                cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setQuality(1);
        cartItem.setProduct(product);
        cartItem.setPrice(product.getProductPrice() * 1);
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @DeleteMapping("/cart/removeCartItem/{cartItemId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartItem(@PathVariable(value = "cartItemId") String cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }

    @DeleteMapping("/cart/removeAllItems/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAllCartItems(@PathVariable(value = "cartId") String cartId) {
        Cart cart = cartService.getCartByCartId(cartId);
        cartItemService.removeAllCartItems(cart);
    }
}
