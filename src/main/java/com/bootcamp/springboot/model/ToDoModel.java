package com.bootcamp.springboot.model;

import java.sql.Timestamp;

public class ToDoModel {
    int id;
    String todo;

    public ToDoModel(){}

    public ToDoModel(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

}
