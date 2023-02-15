//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.schoolmanagementsystem.adminside.security.services;

import com.schoolmanagementsystem.adminside.security.models.Role;
import com.schoolmanagementsystem.adminside.security.models.User;
import com.schoolmanagementsystem.adminside.security.repositories.RoleRepository;
import com.schoolmanagementsystem.adminside.security.repositories.UserRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public RoleService() {
    }

    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    public Role findById(int id) {
        return (Role)this.roleRepository.findById(id).orElse((Role) null);
    }

    public void delete(int id) {
        this.roleRepository.deleteById(id);
    }

    public void save(Role role) {
        this.roleRepository.save(role);
    }

    public void assignUserRole(Integer userId, Integer roleId) {
        User user = (User)this.userRepository.findById(userId).orElse((User) null);
        Role role = (Role)this.roleRepository.findById(roleId).orElse((Role) null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        this.userRepository.save(user);
    }

    public void unassignUserRole(Integer userId, Integer roleId) {
        User user = (User)this.userRepository.findById(userId).orElse((User) null);
        user.getRoles().removeIf((x) -> {
            return x.getId() == roleId;
        });
        this.userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

    public Set<Role> geUserRoles(User user) {
        return user.getRoles();
    }

    public List<Role> getUserNotRoles(User user) {
        return this.roleRepository.getUserNotRoles(user.getId());
    }
}
