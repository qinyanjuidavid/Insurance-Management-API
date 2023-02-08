package org.example.insuranceManagement.repository;

import java.util.List;

import org.example.insuranceManagement.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args-> {
           Product healthProduct=new Product("Health", "Health Insurance", "Health Insurance", 500.0);

           Product propertyProduct=new Product("Property","Property Insurance","Property Insurance",20000.0);
           
           repository.saveAll(List.of(healthProduct,propertyProduct));
        };
    }
}
