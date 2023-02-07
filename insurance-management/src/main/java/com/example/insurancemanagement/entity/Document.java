package com.example.insurancemanagement.entity;

import org.springframework.stereotype.Indexed;

@Entity

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
    private String documentName;
    private String documentType;
    private String documentPath;

    public Document(Long id, Policy policy, String documentName, String documentType, String documentPath) {
        this.id = id;
        this.policy = policy;
        this.documentName = documentName;
        this.documentType = documentType;
        this.documentPath = documentPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", policy=" + policy +
                ", documentName='" + documentName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentPath='" + documentPath + '\'' +
                '}';
    }

}
