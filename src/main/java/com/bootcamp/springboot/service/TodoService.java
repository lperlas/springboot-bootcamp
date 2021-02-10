package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.ToDoModel;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<ToDoModel> todos = new ArrayList<ToDoModel>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    public TodoService() {
        try{
            todos.add(new ToDoModel(1, "Learn Java SpringBoot",
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 09:00").getTime()),
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 11:00").getTime())));
            todos.add(new ToDoModel(2, "Develop Android App",
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 11:00").getTime()),
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 12:00").getTime())));
            todos.add(new ToDoModel(3, "Learn ReactJS",
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 13:00").getTime()),
                    new java.sql.Timestamp(dateFormat.parse("2020-02-11 15:00").getTime())));
        }
        catch(Exception e){

        }
    }

    public List<ToDoModel> getAllTodo(){
        return todos;
    }
}
