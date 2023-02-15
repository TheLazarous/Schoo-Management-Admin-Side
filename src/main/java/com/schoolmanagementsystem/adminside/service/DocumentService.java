//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.service;

import com.schoolmanagementsystem.adminside.model.Documents;

import com.schoolmanagementsystem.adminside.repository.DocumentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
public class DocumentService {
    @Autowired
    DocumentsRepo documentsRepo;
    public static String uploadDirectory;
    private final Path fileStorageLocation;

    public DocumentService() {
        this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
    }

    public String saveFile(Documents documents) throws IOException {
        this.documentsRepo.save(documents);
        return "success";
    }

  /*  public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            System.out.println(filePath + " " + resource);
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException var4) {
            throw new FileNotFoundException("File not found " + fileName, var4);
        }
    }*/

    public Documents storeSubjectImage(MultipartFile file, String ID) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String size = String.valueOf(file.getSize());
        String filePath = Paths.get(uploadDirectory, file.getOriginalFilename()).toString();
        String DocumentPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Subjects";
        new File(DocumentPath);
        if (!Files.exists(Paths.get(DocumentPath), new LinkOption[0])) {
            Files.createDirectories(Paths.get(DocumentPath));
        }

        if (fileName.contains(" ")) {
            fileName = fileName.replace(" ", "_");
        }

        byte[] data = file.getBytes();
        Path path = Paths.get(DocumentPath + File.separator + fileName);

        Files.write(path, data, new LinkOption[0]);
        Documents documents = new Documents(fileName, filePath, size, file.getContentType());
        documents.setSubject_id(ID);
        return (Documents)this.documentsRepo.save(documents);
    }

    public Documents storeTeacherImage(MultipartFile file, String ID) throws IOException {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Teachers";
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String size = String.valueOf(file.getSize());
        String filePath = Paths.get(uploadDirectory, file.getOriginalFilename()).toString();
        String DocumentPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Teachers";
        new File(DocumentPath);
        if (!Files.exists(Paths.get(DocumentPath), new LinkOption[0])) {
            Files.createDirectories(Paths.get(DocumentPath));
        }

        if (fileName.contains(" ")) {
            fileName = fileName.replace(" ", "_");
        }

        byte[] data = file.getBytes();
        Path path = Paths.get(DocumentPath + File.separator + fileName);

        Files.write(path, data, new LinkOption[0]);
        Documents documents = new Documents(fileName, filePath, size, file.getContentType());
        documents.setTeacher_id(ID);
        return (Documents)this.documentsRepo.save(documents);
    }


    static {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "subject";
    }

    public List<Documents> getAllDocuments() {

        return documentsRepo.findAll();
    }
}
