package com.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Shopping.model.Cart;
import com.Shopping.model.Customer;
import com.Shopping.service.CartService;
import com.Shopping.service.CustomerService;

@Controller
public class CartController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    // Using @GetMapping for GET requests
    @GetMapping("cart/getCartById")
    public String getCartId(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailId = user.getUsername();
        Customer customer = customerService.getCustomerByemailId(emailId);
        model.addAttribute("cartId", customer.getCart().getCartId());
        return "cart";
    }

    // Updated to use @GetMapping for path variable
    @GetMapping("/cart/getCart/{cartId}")
    public @ResponseBody Cart getCartItems(@PathVariable(value = "cartId") String cartId) {
        return cartService.getCartByCartId(cartId);
    }
}
