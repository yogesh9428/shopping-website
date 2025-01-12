package com.Shopping.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Shopping.model.Product;
import com.Shopping.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Product List view
    @GetMapping("/getAllProducts")
    public ModelAndView getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ModelAndView("productList", "products", products);
    }

    // Get Product by ID
    @GetMapping("getProductById/{productId}")
    public ModelAndView getProductById(@PathVariable(value = "productId") String productId) {
        Product product = productService.getProductById(productId);
        return new ModelAndView("productPage", "productObj", product);
    }

    // Delete Product
    @DeleteMapping("/admin/delete/{productId}")
    public String deleteProduct(@PathVariable(value = "productId") String productId) {
        Path path = Paths.get("C:/path/to/images/products/" + productId + ".jpg");

        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.deleteProduct(productId);
        return "redirect:/getAllProducts";
    }

    // Add Product Form (GET)
    @GetMapping("/admin/product/addProduct")
    public String getProductForm(Model model) {
        Product product = new Product();
        product.setProductCategory("Android");
        model.addAttribute("productFormObj", product);
        return "addProduct";
    }

    // Add Product (POST)
    @PostMapping("/admin/product/addProduct")
    public String addProduct(@Valid @ModelAttribute(value = "productFormObj") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);
        MultipartFile image = product.getProductImage();
        if (image != null && !image.isEmpty()) {
            Path path = Paths.get("C:/path/to/images/products/" + product.getProductId() + ".jpg");
            try {
                image.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/getAllProducts";
    }

    // Edit Product Form (GET)
    @GetMapping("/admin/product/editProduct/{productId}")
    public ModelAndView getEditForm(@PathVariable(value = "productId") String productId) {
        Product product = productService.getProductById(productId);
        return new ModelAndView("editProduct", "editProductObj", product);
    }

    // Edit Product (POST)
    @PostMapping("/admin/product/editProduct")
    public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
        productService.editProduct(product);
        return "redirect:/getAllProducts";
    }

    // Get Product List as JSON (for Angular or APIs)
    @GetMapping("/getProductsList")
    public @ResponseBody List<Product> getProductsListInJson() {
        return productService.getAllProducts();
    }

    // Angular View for Products
    @GetMapping("/productsListAngular")
    public String getProducts() {
        return "productListAngular";
    }
}
