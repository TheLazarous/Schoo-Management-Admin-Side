//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    public SecurityController() {
    }

    @RequestMapping({"/token"})
    public String tokenPage() {
        return "productkey";
    }

    @GetMapping({"/company"})
    public String company() {
        return "companyPage";
    }

    @RequestMapping({"/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping({"/register"})
    public String register() {
        return "register2";
    }

    @RequestMapping({"/index"})
    public String homePage() {
        return "index";
    }

    @GetMapping({"/accessDenied"})
    public String accessDenied() {
        return "accessDenied";
    }
}
