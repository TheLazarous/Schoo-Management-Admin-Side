package com.schoolmanagementsystem.adminside.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolmanagementsystem.adminside.model.Subject;
import com.schoolmanagementsystem.adminside.service.DocumentService;
import com.schoolmanagementsystem.adminside.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        path = {"api/v1/subject"})
public class SubjectController {
    private final SubjectService subjectService;
    private final DocumentService documentService;
    ObjectMapper objectmapper = new ObjectMapper();

    @Autowired
    public SubjectController(SubjectService subjectService, DocumentService documentService) {
        this.subjectService = subjectService;
        this.documentService = documentService;
    }

    @GetMapping(
            path = {"getSubjects"}
    )
    public List<Subject> getSubjects() {
        return this.subjectService.getSubjects();
    }


    @RequestMapping(
            path = {"addSubject"},
            method = {RequestMethod.POST},
            consumes = {"application/json"}
    )
    public ResponseEntity<String> addSubject(@RequestBody Subject subject)  {

        this.subjectService.addNewSubject(subject);
        String ID = subject.getId().toString();
        String message = "";


        message = "Record Saved with Agreement file successfully : ";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }

}
