package ru.shmvsky.usinghibernate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shmvsky.usinghibernate.dto.TodoDto;
import ru.shmvsky.usinghibernate.entity.Todo;
import ru.shmvsky.usinghibernate.exception.TodoNotFoundException;
import ru.shmvsky.usinghibernate.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Todo save(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.title());
        todo.setDescription(todoDto.description());
        todo.setCompleted(todoDto.completed());
        todoRepository.save(todo);
        return todo;
    }

    public Todo findById(Integer id) {
        return todoRepository.findById(id);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findAll(int page, int size) {
        return todoRepository.findAll(page, size);
    }

    @Transactional
    public Todo update(Integer id, TodoDto todoDto) {
        Todo existingTodo = todoRepository.findById(id);
        if (existingTodo == null) {
            throw new TodoNotFoundException("Todo not found with id: " + id);
        }
        existingTodo.setTitle(todoDto.title());
        existingTodo.setDescription(todoDto.description());
        existingTodo.setCompleted(todoDto.completed());
        todoRepository.update(existingTodo);
        return existingTodo;
    }

    @Transactional
    public void delete(Integer id) {
        Todo existingTodo = todoRepository.findById(id);
        if (existingTodo == null) {
            throw new TodoNotFoundException("Todo not found with id: " + id);
        }
        todoRepository.delete(existingTodo);
    }

}
