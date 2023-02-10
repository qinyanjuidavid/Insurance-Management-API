package org.example.insuranceManagement.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name="Document")
@Table(name="document",
uniqueConstraints={}
)
public class Document {
    @Id
    @SequenceGenerator(
        name = "document_sequence", 
        sequenceName = "document_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE, 
        generator = "document_sequence"
    )
    private Long id;
    @Column(name="document_name", nullable=false, columnDefinition="TEXT")
    private String documentName;
    @Column(name="document_path", nullable=true, columnDefinition="TEXT")
    private String documentPath;
    @ManyToMany
    @JoinTable(
        name="policy_document",
        joinColumns=@JoinColumn(name="document_id"),
        inverseJoinColumns=@JoinColumn(name="policy_id")
    )
    private List<Policy> policy;

    public Document(){}

    public Document(
        Long id,
        String documentName,
        String documentPath,
        List<Policy> policy
    ){
        this.id = id;
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.policy = policy;
    }

       public Document(
        String documentName,
        String documentPath,
        List<Policy> policy
    ){
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.policy = policy;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public List<Policy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", documentPath='" + documentPath + '\'' +
                ", policy=" + policy +
                '}';
    }


}
