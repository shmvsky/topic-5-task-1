package ru.shmvsky.usingspringdatajpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shmvsky.usingspringdatajpa.dto.TodoDto;
import ru.shmvsky.usingspringdatajpa.entity.Todo;
import ru.shmvsky.usingspringdatajpa.exception.TodoNotFoundException;
import ru.shmvsky.usingspringdatajpa.repository.TodoRepository;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Todo save(TodoDto dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.title());
        todo.setDescription(dto.description());
        todo.setCompleted(dto.completed());
        return todoRepository.save(todo);
    }

    public Todo findById(Integer id) {
        var todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        }
        throw new TodoNotFoundException(id);
    }

    public Page<Todo> findAll(int page, int size) {
        return todoRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional
    public Todo update(Integer id, TodoDto todoDto) {
        Optional<Todo> todoOpt = todoRepository.findById(id);
        if (todoOpt.isPresent()) {
            Todo todo = todoOpt.get();
            todo.setTitle(todoDto.title());
            todo.setDescription(todoDto.description());
            todo.setCompleted(todoDto.completed());
            todoRepository.save(todo);
            return todo;
        }
        throw new TodoNotFoundException(id);
    }

    @Transactional
    public void delete(Integer id) {
        var todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            return;
        }
        throw new TodoNotFoundException(id);
    }

}
