package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.ToDoModel;
import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.service.UsersService;
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
@RequestMapping("/users")
public class UsersController {

    private String title="Users Management";
    @Autowired
    private UsersService usersService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("usersList", usersService.findAll());
        model.addAttribute("userNew", new Users());
        return "users";
    }

    @RequestMapping("/getuser/{id}")
    public ResponseEntity<Users> gettodo(@PathVariable("id") long id) {

        return new ResponseEntity<>(this.usersService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/adduser", method= RequestMethod.POST)
    public String addUserProcess(@ModelAttribute("userNew") Users model){
        this.usersService.save(model);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edituser", method= RequestMethod.POST)
    public String editUserProcess(@ModelAttribute("userNew") Users model){
        this.usersService.update(model);
        return "redirect:/users";
    }

    @RequestMapping(value = "/deleteuser/{id}", method= RequestMethod.POST)
    public String deleteUserProcess(@PathVariable("id") long id){
        this.usersService.delete(id);
        return "redirect:/users";
    }
}
