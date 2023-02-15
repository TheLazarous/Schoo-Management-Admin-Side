package com.schoolmanagementsystem.adminside.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolmanagementsystem.adminside.model.Teacher;
import com.schoolmanagementsystem.adminside.service.DocumentService;
import com.schoolmanagementsystem.adminside.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        path = {"api/v1/teacher"})
public class TeacherController {
    private final TeacherService teacherService;
    private final DocumentService documentService;
    ObjectMapper objectmapper = new ObjectMapper();

    @Autowired
    public TeacherController(TeacherService teacherService, DocumentService documentService) {
        this.teacherService = teacherService;
        this.documentService = documentService;
    }

    @GetMapping(
            path = {"getTeachers"}
    )
    public List<Teacher> getTeachers() {
        return this.teacherService.getTeachers();
    }

    @RequestMapping(
            path = {"addTeacher"},
            method = {RequestMethod.POST},
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<String> addTeacher(@RequestParam(required = true, value = "jsondata") String jsondata, @RequestParam(value = "file") MultipartFile file) throws IOException {
        Teacher teacher = (Teacher) this.objectmapper.readValue(jsondata, Teacher.class);
        this.teacherService.addNewTeacher(teacher);
        String ID = teacher.getId().toString();
        String message = "";

        System.out.println("File :" + file.getOriginalFilename());
        try {
            if (!file.getOriginalFilename().isEmpty()) {
                this.documentService.storeTeacherImage(file, ID);

            }
            message = "Record Saved with Agreement file successfully : " + file.getOriginalFilename();

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception var8) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }
}
