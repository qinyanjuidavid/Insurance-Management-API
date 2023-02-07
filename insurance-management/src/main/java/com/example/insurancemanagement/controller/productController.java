package com.example.insurancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurancemanagement.entity.Product;
import com.example.insurancemanagement.services.ProductService;

@RestController
@RequestMapping("api/v1/insurance-products")
public class productController {

    private final ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
}
