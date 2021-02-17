package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.ToDoModel;
import com.bootcamp.springboot.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private ToDoRepository repo;

    private List<ToDoModel> todos = new ArrayList<ToDoModel>();
    private int id=1;
    public TodoService() {
            todos.add(new ToDoModel(id++, "Learn Java SpringBoot"));
            todos.add(new ToDoModel(id++, "Develop Android App"));
            todos.add(new ToDoModel(id++, "Learn ReactJS"));
    }


    public List<ToDoModel> getAllTodo(){
        List<ToDoModel> todos = repo.findAll();
        return todos;
    }

    public ToDoModel getTodo(int id) {
        return repo.findById(id);
    }

    public void addTodo(ToDoModel todo){
        repo.save(todo);
    }

    public void editTodo(ToDoModel todo){
        repo.updateTask(todo.getId(), todo.getTodo());
//
//        todos.stream()
//                .filter(t -> todo.getId() == t.getId())
//                .findFirst()
//                .ifPresent(t -> t.setTodo(todo.getTodo()));
    }

    public void deleteTodo(int id) {
        repo.deleteById(id);
    }
}
