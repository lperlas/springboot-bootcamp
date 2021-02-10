package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.config.DBConfig;
import com.bootcamp.springboot.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.springboot.service.TodoService;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private DBConfig dbconfig;

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index() {
        return "Index";
    }

    @GetMapping("/dbconfig")
    public ResponseEntity<DBConfig> dbconfig() {
        return new ResponseEntity<>(dbconfig, HttpStatus.OK);
    }

    @GetMapping("/todo")
    public ResponseEntity<List<ToDoModel>> todoList(){
        List<ToDoModel> list = this.todoService.getAllTodo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
