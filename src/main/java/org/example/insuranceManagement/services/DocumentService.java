package org.example.insuranceManagement.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.example.insuranceManagement.entity.Document;
import org.example.insuranceManagement.entity.Policy;
import org.example.insuranceManagement.repository.DocumentRepository;
import org.example.insuranceManagement.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final PolicyRepository policyRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, PolicyRepository policyRepository){
        this.documentRepository=documentRepository;
        this.policyRepository=policyRepository;
    }

    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }

    public Document getDocument(Long id){
        Optional <Document> documentOptional = documentRepository.findById(id);
        
        if(!documentOptional.isPresent()){
            throw new IllegalStateException("Document with id " + id + " does not exist");
        }

        return documentOptional.get();
    }

    public Document uploadDocument(Document document, MultipartFile file){
        // ensure that document name is not null
        if(document.getDocumentName() == null || document.getDocumentName().isEmpty()){
            throw new IllegalStateException("Document name is required");
        }

        //ensure that policy is not null
        if(document.getPolicy() == null){
            throw new IllegalStateException("Policy is required");
        }

        for(Policy policy: document.getPolicy()){
            Policy policyFromDb=policyRepository.findById(policy.getId()).orElse(null);

            if(policyFromDb==null){
                throw new IllegalStateException("Policy with id "+policy.getId()+ " does not exist");
            }
        }

        document.setPolicy(document.getPolicy());
        
        // create folder for the documents using the client name
         final Path root= Paths.get("uploads"+File.separator+document.getDocumentName());
        if(!Files.exists(root)){
            try{
                Files.createDirectory(root);
            }catch(IOException e){
                throw new RuntimeException("Could not create directory for upload");
            }
        }

        // save the document
        try{
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        }catch(Exception e){
            if(e instanceof FileAlreadyExistsException){
                throw new RuntimeException("A File with this name already exists");
            }
            throw new RuntimeException("Could not store the file. Error: "+e.getMessage());
        }

        //path to the document
        document.setDocumentPath(root.resolve(file.getOriginalFilename()).toString());

        return documentRepository.save(document);
        
    }




}