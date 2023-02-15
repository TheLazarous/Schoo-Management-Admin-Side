package com.schoolmanagementsystem.adminside.controler;

import com.schoolmanagementsystem.adminside.model.Documents;
import com.schoolmanagementsystem.adminside.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = {"api/v1/documents"})
public class DocumentsController {
    DocumentService documentService;

    @Autowired
    public DocumentsController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(
            path = {"getDocuments"}
    )
    public List<Documents> getDocuments() {
        return this.documentService.getAllDocuments();
    }

}
