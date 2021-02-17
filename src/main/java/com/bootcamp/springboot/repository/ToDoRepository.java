package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ToDoRepository extends JpaRepository<ToDoModel, Integer> {
    ToDoModel findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE ToDoModel SET todo = :todo WHERE id = :id")
    int updateTask(@Param("id") int id, @Param("todo") String todo);
}
