package com.bootcamp.springboot.model;

import java.sql.Timestamp;

public class ToDoModel {
    int id;
    String todo;
    Timestamp startdt;
    Timestamp enddt;

    public ToDoModel(){}

    public ToDoModel(int id, String todo, Timestamp startdt, Timestamp enddt) {
        this.id = id;
        this.todo = todo;
        this.startdt = startdt;
        this.enddt = enddt;
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

    public Timestamp getStartdt() {
        return startdt;
    }

    public void setStartdt(Timestamp startdt) {
        this.startdt = startdt;
    }

    public Timestamp getEnddt() {
        return enddt;
    }

    public void setEnddt(Timestamp enddt) {
        this.enddt = enddt;
    }
}
