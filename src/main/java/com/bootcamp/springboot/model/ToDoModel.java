package com.bootcamp.springboot.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Todo_Perlas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "todo")
    String todo;



}
