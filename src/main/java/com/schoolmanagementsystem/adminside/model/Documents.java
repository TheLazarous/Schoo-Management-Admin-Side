//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.model;

import javax.persistence.*;

@Entity
@Table(
        name = "documents"
)
public class Documents {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "file_name"
    )
    private String fileName;
    @Column(
            name = "file_path"
    )
    private String filePath;
    @Column(
            name = "file_type"
    )
    private String fileType;
    @Column(
            name = "file_size"
    )
    private String fileSize;
    @Column(
            name = "subject_id"
    )
    private String subject_id;

    @Column(
            name = "teacher_id"
    )
    private String teacher_id;

    public Documents() {
    }

    public Documents(Long id, String fileName, String filePath, String fileType, String fileSize) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public Documents(String fileName, String filePath, String fileType, String fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }


    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }


    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String toString() {
        return "Documents{id=" + this.id + ", fileName='" + this.fileName + '\'' + ", filePath='" + this.filePath + '\'' + ", fileType='" + this.fileType + '\'' + ", fileSize='" + this.fileSize + '\'' + '}';
    }
}
