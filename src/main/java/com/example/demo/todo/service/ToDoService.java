package com.example.demo.todo.service;

import com.example.demo.todo.model.Todo;
import com.example.demo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private TodoRepository todoRepository;

    // 1. 모든 todo 항목 조회
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    // 2. 특정 Todo 항목 조회 (ID)
    public Optional<Todo> getTodoById(long id){
        return todoRepository.findById(id);
    }

    // 3. 새로운 Todo 항목 추가
    public Todo addNewTodo(Todo todo){
        return todoRepository.save(todo);
    }

    // 4. 항목수정
    public Todo updateTodo(Long id, Todo updatedTodo){
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setDescription(updatedTodo.getDescription());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    // 5. 삭제
    public void deleteTodoById(long id) {
        todoRepository.deleteById(id);
    }
}
