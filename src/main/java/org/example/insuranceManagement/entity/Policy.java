package org.example.insuranceManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Policy")
@Table(name = "policy", uniqueConstraints = {
    @UniqueConstraint(name = "policy_policy_number_unique", columnNames = "policy_number"),
})
public class Policy {
    @Id
    @SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "policy_number", nullable = false, columnDefinition = "TEXT")
    private String policyNumber;
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;
    @Column(name = "coverage_start_date", nullable = false)
    private LocalDate coverageStartDate;
    @Column(name = "coverage_end_date", nullable = false)
    private LocalDate coverageEndDate;

    public Policy(
        Long id,
        Client client,
        Product product,
        String policyNumber,
        LocalDate issueDate,
        LocalDate coverageStartDate,
        LocalDate coverageEndDate
    ) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.policyNumber = policyNumber;
        this.issueDate = issueDate;
        this.coverageStartDate = coverageStartDate;
        this.coverageEndDate = coverageEndDate;
    }

    // Getters and Setters
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