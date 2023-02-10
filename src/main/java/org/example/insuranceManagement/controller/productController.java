package org.example.insuranceManagement.controller;

import java.util.List;

import org.example.insuranceManagement.entity.Product;
import org.example.insuranceManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/products")
public class productController {
    private final ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/")
    public ResponseEntity<Product> addInsuranceProduct(@RequestBody Product product){
        Product addedProduct= productService.addInsuranceProduct(product);
        return ResponseEntity.ok(addedProduct);
    }


    @DeleteMapping(path="/{productId}")
    public ResponseEntity<String> deleteInsuranceProduct(@PathVariable("productId") Long id){
        productService.deleteInsuranceProduct(id);
        return ResponseEntity.ok("Product with id " + id + " was deleted");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateInsuranceProduct(
        @PathVariable("productId") Long id,
        @RequestBody Product product
    ){
        String name=product.getProductName();
        String type=product.getProductType();
        Product updatedProduct=productService.updateInsuranceProduct(id, name,type);

        return ResponseEntity.ok(updatedProduct);
    }

// @RequestParam(required=false) String productName,
        // @RequestParam(required=false) String productType



}