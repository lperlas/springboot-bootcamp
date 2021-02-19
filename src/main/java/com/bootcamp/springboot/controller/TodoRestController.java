package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.ToDoModel;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "findall", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ToDoModel>> findAll() {
        try {
            return new ResponseEntity<Iterable<ToDoModel>>(todoService.getAllTodo(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<ToDoModel>>(HttpStatus.BAD_REQUEST);
        }
    }
}
