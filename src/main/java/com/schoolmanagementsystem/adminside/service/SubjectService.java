package com.schoolmanagementsystem.adminside.service;

import com.schoolmanagementsystem.adminside.model.Subject;
import com.schoolmanagementsystem.adminside.repository.SubjectRepository;
import com.schoolmanagementsystem.adminside.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubjectService {
     SubjectRepository subjectRepository;
     TeacherRepository teacherRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Subject> getSubjects() {
        List<Subject> list = this.subjectRepository.findAll();
        for (Subject subject : list)
        {
            Long subjectID = subject.getId();
             subject = (Subject) this.subjectRepository.findById(subjectID).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + subjectID + " Does Not Exist");
            });
            Subject finalSubject = subject;
            subject.setTeacher(this.teacherRepository.findById(subject.getTeacher_id()).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + finalSubject.getTeacher_id() + " Does Not Exist");
            }));
        }
        return list;
    }

    public void addNewSubject(Subject subject) {
        this.subjectRepository.save(subject);
    }
}
