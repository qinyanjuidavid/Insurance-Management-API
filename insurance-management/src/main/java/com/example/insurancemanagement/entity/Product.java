package com.example.insurancemanagement.entity;

public class Product{
    private Long id;
    private String product_name;
    private String description;
    private String product_type;
    private double price;

    public Product(Long id, String product_name, String description, String product_type, double price) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

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

}