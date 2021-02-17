package com.bootcamp.springboot.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Todo_Perlas")
public class ToDoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "todo")
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
