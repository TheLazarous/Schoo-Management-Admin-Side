//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.security.controllers;

import com.schoolmanagementsystem.adminside.security.models.User;
import com.schoolmanagementsystem.adminside.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestContoller {
    @Autowired
    private UserService userService;

    public UserRestContoller() {
    }

    @PutMapping({"/updateUser/{username}"})
    public void updateProfile(@RequestBody User user, @PathVariable String username) {
        this.userService.UpadateProfile(user, username);
    }
}
