package org.example.insuranceManagement.services;

import java.util.List;

import org.example.insuranceManagement.entity.Product;
import org.example.insuranceManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getProducts(){
       return productRepository.findAll();
    }
}
