package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.config.DBConfig;
import com.bootcamp.springboot.model.ToDoModel;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private DBConfig dbconfig;

    @Autowired
    private TodoService todoService;

    @Value("${todo.title}")
    private String title;

    @RequestMapping("/login")
    public String login(Model model, String error) {
        return "login";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("todos", this.todoService.getAllTodo());
        model.addAttribute("todoObj", new ToDoModel());
        return "index";
    }

    @RequestMapping("/gettodo/{id}")
    public ResponseEntity<ToDoModel> gettodo(@PathVariable("id") int id) {

        return new ResponseEntity<>(this.todoService.getTodo(id), HttpStatus.OK);
    }

    @RequestMapping("/addtodo")
    public String addTodoShowForm(ToDoModel todo){
        return "addtodo";
    }

    @RequestMapping(value = "/addtodo", method= RequestMethod.POST)
    public String addTodoProcess(@ModelAttribute("todoObj") ToDoModel model){
        this.todoService.addTodo(model);
        return "redirect:/";
    }

    @RequestMapping("/edittodo/{id}")
    public String editTodoShowForm(@PathVariable("id") int id, Model model){
        model.addAttribute("todo",this.todoService.getTodo(id));
        return "edittodo";
    }

    @RequestMapping(value = "/edittodo", method= RequestMethod.POST)
    public String editTodoProcess(@ModelAttribute(value="todoObj") ToDoModel todo){
        this.todoService.editTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/deletetodo/{id}")
    public String deleteTodoProcess(@PathVariable("id") int id){
        this.todoService.deleteTodo(id);
        return "redirect:/";
    }
}
