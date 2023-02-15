//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TenantApplicationController {
    public TenantApplicationController() {
    }

    @GetMapping({"/index"})
    public String home() {
        return "index";
    }
}
