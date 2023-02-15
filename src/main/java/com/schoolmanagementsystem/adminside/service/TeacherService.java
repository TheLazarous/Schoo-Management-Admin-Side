package com.schoolmanagementsystem.adminside.service;

import com.schoolmanagementsystem.adminside.model.Teacher;
import com.schoolmanagementsystem.adminside.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }
}
