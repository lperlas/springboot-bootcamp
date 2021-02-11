package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.config.DBConfig;
import com.bootcamp.springboot.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.springboot.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private DBConfig dbconfig;

    @Autowired
    private TodoService todoService;

    @Value("${todo.title}")
    private String title;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("todos", this.todoService.getAllTodo());
        return "index";
    }

    @RequestMapping("/dbconfig")
    public ResponseEntity<DBConfig> dbconfig() {
        return new ResponseEntity<>(dbconfig, HttpStatus.OK);
    }

    @RequestMapping("/addtodo")
    public String addTodoShowForm(Model model){
        model.addAttribute("todo", new ToDoModel());
        return "addtodo";
    }

    @RequestMapping(value = "/addtodo", method= RequestMethod.POST)
    public String addTodoProcess(@ModelAttribute(value="todo") ToDoModel todo){
        this.todoService.addTodo(todo);
        return "redirect:/";
    }

    @RequestMapping("/edittodo/{id}")
    public String editTodoShowForm(@PathVariable("id") long id, Model model){
        model.addAttribute("todo",this.todoService.getTodo(id));
        return "edittodo";
    }

    @RequestMapping(value = "/edittodo", method= RequestMethod.POST)
    public String editTodoProcess(@ModelAttribute(value="todo") ToDoModel todo){
        this.todoService.editTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/deletetodo/{id}")
    public String deleteTodoProcess(@PathVariable("id") long id, Model model){
        this.todoService.deleteTodo(id);
        return "redirect:/";
    }
}
