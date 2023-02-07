package com.example.insurancemanagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String policyNumber;
    private LocalDate issueDate;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;


    public Policy(Long id, Client client, Product product, String policyNumber, LocalDate issueDate, LocalDate coverageStartDate, LocalDate coverageEndDate) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.policyNumber = policyNumber;
        this.issueDate = issueDate;
        this.coverageStartDate = coverageStartDate;
        this.coverageEndDate = coverageEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getCoverageStartDate() {
        return coverageStartDate;
    }

    public void setCoverageStartDate(LocalDate coverageStartDate) {
        this.coverageStartDate = coverageStartDate;
    }

    public LocalDate getCoverageEndDate() {
        return coverageEndDate;
    }

    public void setCoverageEndDate(LocalDate coverageEndDate) {
        this.coverageEndDate = coverageEndDate;
    }


    @Override
    public String toString() {
        return "Policy [client=" + client + ", coverageEndDate=" + coverageEndDate + ", coverageStartDate="
                + coverageStartDate + ", id=" + id + ", issueDate=" + issueDate + ", policyNumber=" + policyNumber
                + ", product=" + product + "]";
    }

}
