package org.example.insuranceManagement.controller;

import java.util.List;

import org.example.insuranceManagement.entity.Document;
import org.example.insuranceManagement.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path="api/v1/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService){
        this.documentService=documentService;
    }

    @GetMapping
    public List<Document> getDocuments(){
        return documentService.getDocuments();
    }

    @GetMapping(path="/{documentId}")
    public Document getDocument(@PathVariable("documentId") Long id){
        return documentService.getDocument(id);
    }

    //upload document
    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestBody Document document, @RequestParam("file") MultipartFile file){
        Document newDocument= documentService.uploadDocument(document, file);

        return ResponseEntity.ok(newDocument);
    }

}
