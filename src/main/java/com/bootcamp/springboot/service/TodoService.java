package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.ToDoModel;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<ToDoModel> todos = new ArrayList<ToDoModel>();
    private int id=1;
    public TodoService() {
            todos.add(new ToDoModel(id++, "Learn Java SpringBoot"));
            todos.add(new ToDoModel(id++, "Develop Android App"));
            todos.add(new ToDoModel(id++, "Learn ReactJS"));
    }


    public List<ToDoModel> getAllTodo(){
        return todos;
    }

    public ToDoModel getTodo(long id) {
        return todos.stream()
                .filter(t -> id == t.getId())
                .findAny()
                .orElse(null);
    }

    public void addTodo(ToDoModel todo){
        todo.setId(id++);
        todos.add(todo);
    }

    public void editTodo(ToDoModel todo){
        todos.stream()
                .filter(t -> todo.getId() == t.getId())
                .findFirst()
                .ifPresent(t -> t.setTodo(todo.getTodo()));
    }

    public void deleteTodo(long id) {
        ToDoModel todo = getTodo(id);

        todos.remove(todos.indexOf(todo));
    }
}
