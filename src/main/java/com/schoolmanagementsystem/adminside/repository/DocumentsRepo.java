//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.repository;

import com.schoolmanagementsystem.adminside.model.Documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepo extends JpaRepository<Documents, Long> {
    @Query(
            value = "SELECT p.id,p.name,p.data,p.type FROM documents p INNER JOIN lease s   on p.id where p.id=s.id and s.status=?1 ",
            nativeQuery = true
    )
    List<Documents> findExpired(String status);



}
