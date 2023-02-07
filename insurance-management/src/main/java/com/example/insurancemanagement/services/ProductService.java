package com.example.insurancemanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.insurancemanagement.entity.Product;

@Service
public class ProductService {
    public List<Product> getProducts() {
		return List.of(
				new Product(1L, "Car Insurance", "Car Insurance", "Car", 1000.00),
				new Product(2L, "Home Insurance", "Home Insurance", "Home", 2000.00),
				new Product(3L, "Life Insurance", "Life Insurance", "Life", 3000.00)
				);
	}
}
