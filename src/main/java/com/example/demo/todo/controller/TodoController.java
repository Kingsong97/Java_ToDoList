package com.example.demo.todo.controller;

import com.example.demo.todo.model.Todo;
import com.example.demo.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TodoController {

    @Autowired
    private ToDoService toDoService;

    // 1. 모든 todo 항목 조회 (Get 요청)
    @GetMapping
    public List<Todo> getAllTodos(){
        return toDoService.getAllTodos();
    }

    // 2. 특정 ID 항목 조회 (Get 요청)
    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable("id") Long id){
        return toDoService.getTodoById(id);
    }

    // 3. 새로운 항목 추가 (Post 요청)
    @PostMapping
    public Todo addNewTodo(@RequestBody Todo todo){
        return toDoService.addNewTodo(todo);
    }

    // 4. 수정 (Put 요청)
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo updatedTodo){
        return toDoService.updateTodo(id, updatedTodo);
    }

    // 5. 삭제 (Delete)
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") Long id){
        toDoService.deleteTodoById(id);
    }
}
