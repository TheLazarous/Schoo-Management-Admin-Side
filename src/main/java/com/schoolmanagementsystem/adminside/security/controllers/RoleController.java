//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.security.controllers;

import com.schoolmanagementsystem.adminside.security.models.Role;
import com.schoolmanagementsystem.adminside.security.services.RoleService;
import com.schoolmanagementsystem.adminside.security.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    public RoleController() {
    }

    @GetMapping({"/security/roles"})
    public String parameters(Model model) {
        List<Role> roles = this.roleService.findAll();
        model.addAttribute("roles", roles);
        return "security/roles";
    }

    @GetMapping({"/security/role/{id}"})
    @ResponseBody
    public Role getById(@PathVariable Integer id) {
        return this.roleService.findById(id);
    }

    @PostMapping({"/security/roles"})
    public String save(Role role) {
        this.roleService.save(role);
        return "redirect:/security/roles";
    }

    @RequestMapping(
            value = {"/security/role/delete/{id}"},
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    public String delete(@PathVariable Integer id) {
        this.roleService.delete(id);
        return "redirect:/security/roles";
    }

    @RequestMapping({"/security/role/assign/{userId}/{roleId}"})
    public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
        this.roleService.assignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/" + userId;
    }

    @RequestMapping({"/security/role/unassign/{userId}/{roleId}"})
    public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
        this.roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/" + userId;
    }
}
