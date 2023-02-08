package org.example.insuranceManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "Product")
@Table(name = "product",uniqueConstraints = {
    @UniqueConstraint(name = "product_name_unique", columnNames = "product_name")
})
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "product_name", nullable = false, columnDefinition = "TEXT")
    private String product_name;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(name = "product_type", nullable = true, columnDefinition = "TEXT")
    private String product_type;
    
    @Column(name = "price", nullable = false, columnDefinition = "float")
    private double price;

    public Product(
        Long id,
        String product_name,
        String description,
        String product_type,
        double price
    ) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.product_type = product_type;
        this.price = price;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_type() {
        return product_type;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [description=" + description + ", id=" + id + ", price=" + price + ", product_name=" + product_name
                + ", product_type=" + product_type + "]";
    }
     
    
}
