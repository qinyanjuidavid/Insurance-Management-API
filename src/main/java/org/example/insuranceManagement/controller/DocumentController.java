package org.example.insuranceManagement.controller;

import java.util.List;

import org.example.insuranceManagement.entity.Document;
import org.example.insuranceManagement.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



    // //upload document
    // @PostMapping("/upload")
    // public ResponseEntity<Document> uploadDocument(@RequestBody Document document, @RequestParam("file") MultipartFile file){
    //     Document newDocument= documentService.uploadDocument(document, file);

    //     return ResponseEntity.ok(newDocument);
    // }

    //sample code for uploading multiple files
    // public static final String DIRECTORY= System.getProperty("user.dir")+"/uploads/";

    // @PostMapping("/uploadMultipleFiles")
    // public ResponseEntity<List<String>> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) throws IOException{
    //     List<String> fileNames= new ArrayList<>();
    //     for (MultipartFile file: files){
    //     String filename= StringUtils.cleanPath(file.getOriginalFilename());
    //     Path fileStorage=get(DIRECTORY,filename).toAbsolutePath().normalize();
    //     copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
    //     fileNames.add(filename);

    //     }
    //     return ResponseEntity.ok().body(fileNames);

    // }

    // private Path get(String directory2, String filename) {
    //     return null;
    // }

}
