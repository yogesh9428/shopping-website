package com.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Shopping.model.Cart;
import com.Shopping.model.Customer;
import com.Shopping.model.CustomerOrder;
import com.Shopping.service.CartService;
import com.Shopping.service.CustomerOrderService;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") String cartId, Model model) {

        Cart cart = cartService.getCartByCartId(cartId);
        if (cart == null) {
            model.addAttribute("error", "Cart not found for ID: " + cartId);
            return "error";  // Return an error view if cart not found
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        if (customer == null) {
            model.addAttribute("error", "Customer not found for the given cart.");
            return "error";  // Return an error view if customer not found
        }

        customerOrder.setCustomer(customer);
        customerOrder.setShippingAddress(customer.getShippingAddress());
        customerOrder.setBillingAddress(customer.getBillingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId=" + cartId;
    }
}
