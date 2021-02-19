package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Role;
import com.bootcamp.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/roles")
public class RoleController {


    private String title="Roles Management";

    @Autowired
    private RoleService roleService;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", title);
        model.addAttribute("roleList", roleService.getAllRoles());
        model.addAttribute("rolesNew", new Role());
        return "roles";
    }

    @RequestMapping("/getrole/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/addrole", method = RequestMethod.POST)
    public String addRoleProcess(@ModelAttribute("roleNew") Role role){
        this.roleService.addRole(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/editrole", method = RequestMethod.POST)
    public String editRoleProcess(@ModelAttribute("roleNew") Role role){
        this.roleService.updateRole(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/deleterole/{id}", method= RequestMethod.POST)
    public String deleteRoleProcess(@PathVariable("id") long id){
        this.roleService.deleteRole(id);
        return "redirect:/roles";
    }
}
